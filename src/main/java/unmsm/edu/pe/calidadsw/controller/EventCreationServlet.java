package unmsm.edu.pe.calidadsw.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import unmsm.edu.pe.calidadsw.dao.DAOFactory;
import unmsm.edu.pe.calidadsw.dao.design.IAmbientDAO;
import unmsm.edu.pe.calidadsw.dao.design.IEventDAO;
import unmsm.edu.pe.calidadsw.dao.model.Administrator;
import unmsm.edu.pe.calidadsw.dao.model.Ambient;
import unmsm.edu.pe.calidadsw.dao.model.Event;
import unmsm.edu.pe.calidadsw.dao.model.Type;

/**
 *
 * @author antony
 */
@WebServlet(name = "events_create", urlPatterns = { "/events_create" })
public class EventCreationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(EventCreationServlet.class.getName());
    static IEventDAO eventDAO = DAOFactory.getInstance().getEventDAO();
    static IAmbientDAO ambientDAO = DAOFactory.getInstance().getAmbientDAO();
    private static final String EVENT = "event";
    private static final String MESSAGE = "message";
    private static final String ERRORMESSAGE = "errorMsg";
    private static final String AMBIENT = "ambient";

    public EventCreationServlet() {
        super();
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

        try {
            switch (action) {
            case "index":
                index(request, response);
                break;
            case "second":
                second(request, response);
                break;
            case "third":
                third(request, response);
                break;
            default:
                break;
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            switch (action) {
            case "create1":
                create1(request, response);
                break;
            case "create2":
                create2(request, response);
                break;
            case "create3":
                create3(request, response);
                break;
            default:
                break;
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Type> types = eventDAO.readTypes();

        Calendar fecha = Calendar.getInstance();
        String dateNow = new SimpleDateFormat("yyyy-MM-dd").format(fecha.getTime());

        request.setAttribute("dateNow", dateNow);
        request.setAttribute("types", types);

        request.getRequestDispatcher("eventCreation.jsp").forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void create1(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Event event = new Event();

        event.setTitle(request.getParameter("title"));
        event.setDescription(request.getParameter("description"));
        event.setDate(request.getParameter("date"));
        event.setDateEnd(request.getParameter("date_end"));

        Type type = new Type();
        type.setIdType(Integer.parseInt(request.getParameter("type-event")));
        event.setType(type);

        Administrator administrator = new Administrator();
        administrator.setIdAdministrator(1);
        event.setAdministrator(administrator);

        String e = "";
        if ((event.getDate()).compareTo(event.getDateEnd()) > 0) {
            e = "<div class='alert alert-warning' role='alert'>La fecha de inicio no puede ser posterior"
                    + " a la final.</div>";

            request.setAttribute(ERRORMESSAGE, e);
            index(request, response);
        } else {
            int idEvent = 0;
            idEvent = eventDAO.createBasic(event);

            if (idEvent == 0) {
                e = "<div class='alert alert-danger' role='alert'>Ocurrio un error al crear el evento vuelva a "
                        + "intentarlo más tarde.</div>";

                request.setAttribute(ERRORMESSAGE, e);
                index(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute(EVENT, idEvent);

                response.sendRedirect("./events_create?action=second");
            }
        }

    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void second(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer idEvent = (Integer) session.getAttribute(EVENT);

        if (idEvent == null) {
            String e = "<div class='alert alert-danger' role='alert'>Ocurrio un error vuelva intentarlo más tarde.</div>";

            request.setAttribute(ERRORMESSAGE, e);
            index(request, response);
        } else {
            List<Ambient> elements = ambientDAO.filterAmbients(idEvent);

            request.setAttribute("ambients", elements);
            request.getRequestDispatcher("eventCreationS2.jsp").forward(request, response);
        }
    }

    /**
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    private void create2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Ambient ambient = new Ambient();

        ambient.setIdAmbient(Integer.parseInt(request.getParameter("environment")));

        HttpSession session = request.getSession();
        session.setAttribute(AMBIENT, ambient.getIdAmbient());

        response.sendRedirect("./events_create?action=third");
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void third(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer idEvent = (Integer) session.getAttribute(EVENT);
        Integer idAmbient = (Integer) session.getAttribute(AMBIENT);

        Event event = new Event();
        Ambient ambient = new Ambient();

        event.setIdEvent(idEvent);
        ambient.setIdAmbient(idAmbient);
        event.setAmbient(ambient);

        List<Event> eventsHours = eventDAO.filterSchedule(event);
        List<Event> hours = new ArrayList<>();

        if (!eventsHours.isEmpty()) {
            for (int i = 9; i < 25; i++) {
                Event e = new Event();
                e.setStartTime(i - 1);
                e.setEndTime(i);

                boolean find = false;
                for (int j = 0; j < eventsHours.size() && !find; j++) {

                    if (eventsHours.get(j).getStartTime() == i - 1) {
                        e.setIdEvent(1);
                        find = true;
                    }
                }

                hours.add(e);
            }
        } else {
            for (int i = 9; i < 25; i++) {
                Event e = new Event();
                e.setStartTime(i - 1);
                e.setEndTime(i);
                hours.add(e);
            }
        }

        request.setAttribute("events", hours);

        Event eventDay = eventDAO.getDayEvents(idEvent);

        request.setAttribute("eventDay", eventDay);
        request.getRequestDispatcher("eventCreationS3.jsp").forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void create3(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Event event = new Event();

        if (request.getParameterValues("hour") == null) {
            request.setAttribute(MESSAGE, "<div class='alert alert-warning' role='alert'>Debe seleccionar "
                    + "algun horario o regresar y cambiar de ambiente</div>");
            third(request, response);
        } else {
            String[] hours = request.getParameterValues("hour");

            int index = 0;
            StringBuilder bld = new StringBuilder();
            for (String hr : hours) {

                if (index > 0) {
                    bld.append(";");
                }
                bld.append(hr);

                index++;
            }
            HttpSession session = request.getSession();
            Integer idEvent = (Integer) session.getAttribute(EVENT);
            Integer idAmbient = (Integer) session.getAttribute(AMBIENT);

            event.setIdEvent(idEvent);
            event.setAmbient(new Ambient(idAmbient));

            if (eventDAO.finalCreate(event, bld.toString())) {
                response.sendRedirect("./events?accion=index");
            } else {
                session.removeAttribute(EVENT);

                request.setAttribute(ERRORMESSAGE,
                        "<div class='alert alert-danger' role='alert'>Ocurrio un error al añadir los "
                                + "horarios vuelva a intentarlo más tarde.</div>");
                index(request, response);
            }

        }

    }

}
