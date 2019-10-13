/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.calidadsw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "EventManagementServlet", urlPatterns = {"/EventManagementServlet"})
public class EventManagementServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger("JDBCDataAccessClass");
    //static AmbientDAO ambientDAO = new AmbientDAO();
    static IEventDAO eventDAO = DAOFactory.getInstance().getEventDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EventManagementServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EventManagementServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Event> elements;
        try {
            elements = eventDAO.read();
            request.setAttribute("eventos", elements);
            request.getRequestDispatcher("eventManagement.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = request.getParameter("tipo");

        if (tipo.equals("buscar")) {
            String fecha_inicio = request.getParameter("start_date");
            String fecha_fin = request.getParameter("end_date");

            /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date1 = sdf.parse(fecha_inicio);
                Date date2 = sdf.parse(fecha_fin);

                int cd = date1.compareTo(date2);

                switch (cd) {
                    case 1:
                        List<Event> elements;
                        try {
                            elements = eventDAO.search(fecha_inicio, fecha_fin);
                            request.setAttribute("eventos", elements);
                            request.getRequestDispatcher("eventManagement.jsp").forward(request, response);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case -1:
                        request.setAttribute("e", "Coloca bien las fechas para realizar la búsqueda.");
                        request.getRequestDispatcher("eventManagement.jsp").forward(request, response);
                        break;

                    case 0:
                        request.setAttribute("e", "Las fechas no pueden ser iguales.");
                        request.getRequestDispatcher("eventManagement.jsp").forward(request, response);
                        break;

                    default:
                        //???
                        break;
                }*/

                List<Event> elements;
                try {
                    elements = eventDAO.search(fecha_inicio, fecha_fin);
                    request.setAttribute("eventos", elements);
                    request.getRequestDispatcher("eventManagement.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                /*if (date1.compareTo(date2) > 0) {
                    List<Event> elements;
                    try {
                        elements = eventDAO.search(fecha_inicio, fecha_fin);
                        request.setAttribute("eventos", elements);
                        request.getRequestDispatcher("eventManagement.jsp").forward(request, response);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (date1.compareTo(date2) < 0) {
                    request.setAttribute("e", "Coloca bien las fechas para realizar la búsqueda.");
                    request.getRequestDispatcher("eventManagement.jsp").forward(request, response);
                } else if (date1.compareTo(date2) == 0) {
                    request.setAttribute("e", "Las fechas no pueden ser iguales.");
                    request.getRequestDispatcher("eventManagement.jsp").forward(request, response);
                }*/
            /*} catch (ParseException ex) {
                Logger.getLogger(EventManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            }*/

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
