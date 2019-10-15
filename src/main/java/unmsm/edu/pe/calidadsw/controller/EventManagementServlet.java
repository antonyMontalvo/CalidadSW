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
import unmsm.edu.pe.calidadsw.dao.design.IEventDAO;
import unmsm.edu.pe.calidadsw.dao.model.Event;

/**
 *
 * @author antony
 */
@WebServlet(name = "events", urlPatterns = { "/events" })
public class EventManagementServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(EventManagementServlet.class.getName());
    static IEventDAO eventDAO = DAOFactory.getInstance().getEventDAO();
    private static final String MESSAGE = "message";

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
        String action = request.getParameter("accion");

        try {
            switch (action) {
            case "index":
                index(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "publish":
                publish(request, response);
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

        String startDate = request.getParameter("start-date");
        String endDate = request.getParameter("end-date");
        List<Event> elements;
        try {
            elements = eventDAO.search(startDate, endDate);
            request.setAttribute("eventos", elements);
            request.getRequestDispatcher("eventManagement.jsp").forward(request, response);
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
        List<Event> elements = eventDAO.read();

        request.setAttribute("eventos", elements);
        request.getRequestDispatcher("eventManagement.jsp").forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Event event = eventDAO.readEvent(id);

        if (event == null) {
            request.setAttribute(MESSAGE, "<div class='alert alert-danger' role='alert'>No existe este evento</div>");
        } else {
            request.setAttribute("event", event);
        }

        request.getRequestDispatcher("eventUpdate.jsp").forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        if (eventDAO.delete(id)) {
            request.setAttribute(MESSAGE,
                    "<div class='alert alert-success' role='alert'>Se elimino correctamente</div>");
        } else {
            request.setAttribute(MESSAGE,
                    "<div class='alert alert-danger' role='alert'>Ocurrio un error al eliminar el evento</div>");
        }

        index(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void publish(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        if (eventDAO.publish(id)) {
            request.setAttribute(MESSAGE,
                    "<div class='alert alert-success' role='alert'>Se publico correctamente</div>");
        } else {
            request.setAttribute(MESSAGE,
                    "<div class='alert alert-danger' role='alert'>Ocurrio un error al publicar el evento</div>");
        }

        index(request, response);
    }

}
