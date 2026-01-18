package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import dao.AdminDAO;

public class AdminLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (AdminDAO.validate(email, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("admin", email);
            res.sendRedirect("admin/dashboard.jsp");
        } else {
            req.setAttribute("msg", "Invalid Credentials");
            req.getRequestDispatcher("login.jsp").forward(req, res);
        }
    }
}
