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
import unmsm.edu.pe.calidadsw.dao.design.IExhibitorDAO;
import unmsm.edu.pe.calidadsw.dao.model.Event;
import unmsm.edu.pe.calidadsw.dao.model.Exhibitor;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "EventExpositorServlet", urlPatterns = { "/EventExpositorServlet" })
public class EventExpositorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(EventExpositorServlet.class.getName());
    static IExhibitorDAO exhibitorDAO = DAOFactory.getInstance().getExhibitorDAO();
    static IEventDAO eventDAO = DAOFactory.getInstance().getEventDAO();

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

        List<Event> events;
        try {
            events = eventDAO.read();
            request.setAttribute("events", events);
            request.getRequestDispatcher("eventExhibitor.jsp").forward(request, response);
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

        List<Exhibitor> exhibitors;
        List<Event> events;
        
        try {
            events = eventDAO.read();
            request.setAttribute("events", events);

            int idEvent = Integer.parseInt(request.getParameter("eventId"));
            exhibitors = exhibitorDAO.readExhibitorEvent(idEvent);
            request.setAttribute("exhibitors", exhibitors);
            request.getRequestDispatcher("eventExhibitor.jsp").forward(request, response);
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

}
