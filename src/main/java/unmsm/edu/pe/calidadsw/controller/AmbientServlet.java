package unmsm.edu.pe.calidadsw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unmsm.edu.pe.calidadsw.dao.implement.AmbientDAO;

@WebServlet("/ambients")
public class AmbientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    AmbientDAO ambientDAO;

    public void init() {
        try {
            ambientDAO = new AmbientDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AmbientServlet() {
        super();
    }

    protected void proccesRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet" + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            proccesRequest(request, response);
            // } catch (SQLException e) {
            // e.printStackTrace();
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            proccesRequest(request, response);
            // } catch (SQLException e) {
            // e.printStackTrace();
        } finally {
            out.close();
        }
    }

    @Override
    public String getServletInfo() {
        return "My servlet";
    }
}