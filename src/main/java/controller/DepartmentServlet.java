package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import dao.DepartmentDAO;
import model.Department;

public class DepartmentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String deptName = req.getParameter("deptName");

        Department d = new Department();
        d.setDeptName(deptName);

        DepartmentDAO.save(d);
        res.sendRedirect("admin/dashboard.jsp");
    }
}
