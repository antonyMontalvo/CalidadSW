package unmsm.edu.pe.calidadsw.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unmsm.edu.pe.calidadsw.dao.DAOFactory;
import unmsm.edu.pe.calidadsw.dao.design.IAdministratorDAO;
import unmsm.edu.pe.calidadsw.dao.model.Administrator;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "login", urlPatterns = { "", "/", "/login" })
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());
    static IAdministratorDAO adminDAO = DAOFactory.getInstance().getAdministratorDAO();

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
        try {

            request.getRequestDispatcher("eventLogin.jsp").forward(request, response);
            // Puesto simplemente para que cargue el servlet al inicio
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

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Administrator adminData;
        try {
            adminData = adminDAO.readLogin(username);

            if (adminData != null && password.equals(adminData.getPassword())) {
                HttpSession s = request.getSession();
                s.setAttribute("username", adminData.getUsername());
                response.sendRedirect("eventStartPage.jsp");
            } else {
                request.setAttribute("e", "Error al iniciar sesión.");
                request.getRequestDispatcher("eventLogin.jsp").forward(request, response);
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

}
