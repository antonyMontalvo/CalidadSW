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
import unmsm.edu.pe.calidadsw.dao.model.Ambient;

@WebServlet(name = "ambients", urlPatterns = { "/ambients" })
public class AmbientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(AmbientServlet.class.getName());
    static IAmbientDAO ambientDAO = DAOFactory.getInstance().getAmbientDAO();

    public AmbientServlet() {
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

        List<Ambient> elements;

        try {
            elements = ambientDAO.read();
            request.setAttribute("ambientes", elements);
            request.getRequestDispatcher("eventEnviroment.jsp").forward(request, response);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "My servlet";
    }
}