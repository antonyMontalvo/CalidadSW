package unmsm.edu.pe.calidadsw.controller;

import java.io.IOException;
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
            case "create1":
                create1(request, response);
                break;
            case "second":
                second(request, response);
                break;
            case "create2":
                create2(request, response);
                break;
            case "third":
                third(request, response);
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
        doGet(request, response);
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
        request.getRequestDispatcher("eventCreation.jsp").forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    private void create1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Event event = new Event();

        event.setTitle(request.getParameter("title"));
        event.setDescription(request.getParameter("description"));
        event.setDate(request.getParameter("date"));
        event.setState("creado");

        Administrator administrator = new Administrator();
        administrator.setIdAdministrator(1);
        event.setAdministrator(administrator);

        int idEvent = 0;
        idEvent = eventDAO.createBasic(event);
        if (idEvent == 0) {
            response.sendRedirect("./events_create?action=index");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("event", idEvent);
            response.sendRedirect("./events_create?action=second");
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
        Integer idEvent = (Integer) session.getAttribute("event");

        if (idEvent == null) {
            response.sendRedirect("./events_create?action=index");
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
     * @throws ServletException
     * @throws IOException
     */
    private void create2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Event event = new Event();
        Ambient ambient = new Ambient();

        ambient.setIdAmbient(Integer.parseInt(request.getParameter("environment")));
        event.setAmbient(ambient);

        HttpSession session = request.getSession();
        Integer idEvent = (Integer) session.getAttribute("event");
        event.setIdEvent(idEvent);

        boolean status = eventDAO.createSecond(event);
        if (status) {
            session.setAttribute("status", true);
            response.sendRedirect("./events_create?action=third");
        } else {
            session.removeAttribute("event");
            response.sendRedirect("./events_create?action=index");
        }
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
        Integer idEvent = (Integer) session.getAttribute("event");
        boolean status = (Boolean) session.getAttribute("status");

        if (!status) {
            
        } else {
            List<Event> elements = eventDAO.filterSchedule(idEvent);

            request.setAttribute("ambients", elements);
            request.getRequestDispatcher("eventCreationS2.jsp").forward(request, response);
        }
        request.getRequestDispatcher("eventCreationS3.jsp").forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void create3(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Event event = new Event();

        event.setStartTime(Integer.parseInt(request.getParameter("start-time")));
        event.setEndTime(Integer.parseInt(request.getParameter("end-time")));

        HttpSession session = request.getSession();
        Integer idEvent = (Integer) session.getAttribute("event");
        event.setIdEvent(idEvent);

        boolean status = eventDAO.finalCreate(event);
        if (status) {
            response.sendRedirect("./events");
        } else {
            session.removeAttribute("event");
            response.sendRedirect("./events_create?action=index");
        }
    }

}
