package unmsm.edu.pe.calidadsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unmsm.edu.pe.calidadsw.dao.DAOFactory;
import unmsm.edu.pe.calidadsw.dao.design.IPresentationDAO;
import unmsm.edu.pe.calidadsw.dao.model.Event;
import unmsm.edu.pe.calidadsw.dao.model.Exhibitor;
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

            int startT = presentations.get(0).getEvent().getStartTime();
            request.setAttribute("eventStartTime", startT);

            int endT = presentations.get(0).getEvent().getEndTime();
            request.setAttribute("eventEndTime", endT);

            request.setAttribute("ambientName", presentations.get(0).getEvent().getAmbient().getName());
            request.setAttribute("ambientDescription", presentations.get(0).getEvent().getAmbient().getDescription());
            request.setAttribute("ambientCapacity", presentations.get(0).getEvent().getAmbient().getCapacity());

            request.setAttribute("presentations", presentations);

            if (presentations.get(0).getExhibitor().getName() == null) {

                Map<Integer, List<Presentation>> hashMap = presentationDAO.getAlgoritmo(presentations);
                request.setAttribute("exhibitors", hashMap);

                List<Presentation> nList = new ArrayList<>();

                for (int i = startT; i < endT; i++) {
                    Presentation presentation = new Presentation();
                    presentation.setStartTime(i);
                    presentation.setEndTime(i + 1);

                    nList.add(presentation);
                }

                request.setAttribute("schedule", nList);
            }

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
            Presentation presentation = new Presentation();
            Event event = new Event();
            Exhibitor exhibitor = new Exhibitor();

            event.setIdEvent(Integer.parseInt(request.getParameter("event-id")));
            presentation.setEvent(event);

            exhibitor.setIdExhibitor(Integer.parseInt(request.getParameter("exhibitor-id")));

            presentation.setTheme(request.getParameter("theme"));
            presentation.setStartTime(Integer.parseInt(request.getParameter("star-time")));
            presentation.setEndTime(Integer.parseInt(request.getParameter("end-time")));

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