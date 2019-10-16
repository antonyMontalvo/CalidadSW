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
import unmsm.edu.pe.calidadsw.dao.design.IPresentationDAO;
import unmsm.edu.pe.calidadsw.dao.model.Presentation;

/**
 *
 * @author antony
 */
@WebServlet(name = "events_update", urlPatterns = { "/events_update" })
public class EventUpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(EventUpdateServlet.class.getName());
    static IPresentationDAO presentationDAO = DAOFactory.getInstance().getPresentationDAO();

    public EventUpdateServlet() {
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

        List<Presentation> presentations;
        try {
            int idEvent = Integer.parseInt(request.getParameter("id"));

            presentations = presentationDAO.readExhibitorsEvent(idEvent);

            request.setAttribute("eventTitle", presentations.get(0).getEvent().getTitle());
            request.setAttribute("eventDate", presentations.get(0).getEvent().getDate());
            request.setAttribute("eventDescription", presentations.get(0).getEvent().getDescription());
            request.setAttribute("eventState", presentations.get(0).getEvent().getState());
            request.setAttribute("eventStartTime", presentations.get(0).getEvent().getStartTime());
            request.setAttribute("eventEndTime", presentations.get(0).getEvent().getEndTime());
            
            request.setAttribute("ambientName", presentations.get(0).getEvent().getAmbient().getName());
            request.setAttribute("ambientDescription", presentations.get(0).getEvent().getAmbient().getDescription());
            request.setAttribute("ambientCapacity", presentations.get(0).getEvent().getAmbient().getCapacity());

            request.setAttribute("presentations", presentations);
            request.getRequestDispatcher("eventUpdate.jsp").forward(request, response);
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

        try {
            response.sendRedirect("./events?accion=index");
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
