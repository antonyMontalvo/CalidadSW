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

    private int idEvent = 0;

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

        idEvent = eventDAO.createBasic(event);
        if (idEvent != 0) {
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
        List<Ambient> elements = ambientDAO.filterAmbients(idEvent);

        request.setAttribute("ambients", elements);
        request.getRequestDispatcher("eventCreationS2.jsp").forward(request, response);
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
        request.getRequestDispatcher("eventCreationS2.jsp").forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void third(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        request.getRequestDispatcher("eventCreationS3.jsp").forward(request, response);
    }

}
