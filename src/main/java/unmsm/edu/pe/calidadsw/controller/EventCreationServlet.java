package unmsm.edu.pe.calidadsw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unmsm.edu.pe.calidadsw.dao.component.AmbientDAO;
import unmsm.edu.pe.calidadsw.dao.component.EventDAO;
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
    private static final Logger LOGGER = Logger.getLogger("EventCreationServlet");
    static EventDAO eventDAO = new EventDAO();
    static AmbientDAO ambientDAO = new AmbientDAO();

    public EventCreationServlet() {
        super();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter();) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EventCreationServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EventCreationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
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
            // request.getRequestDispatcher("eventCreation.jsp").forward(request, response);
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

    private void create1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

    private void second(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ambient> elements = ambientDAO.filterAmbients(idEvent);

        request.setAttribute("ambients", elements);
        request.getRequestDispatcher("eventCreationS2.jsp").forward(request, response);
    }

    private void create2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("eventCreationS2.jsp").forward(request, response);
    }

    private void third(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("eventCreationS3.jsp").forward(request, response);
    }

    private void create3(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("eventCreationS3.jsp").forward(request, response);
    }
}
