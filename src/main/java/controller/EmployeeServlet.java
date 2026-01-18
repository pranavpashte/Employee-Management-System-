package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import model.Employee;
import dao.EmployeeDAO;

public class EmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Employee e = new Employee();
        e.setName(req.getParameter("name"));
        e.setEmail(req.getParameter("email"));
        e.setSalary(Double.parseDouble(req.getParameter("salary")));
        e.setRole(req.getParameter("role"));
        e.setDeptId(Integer.parseInt(req.getParameter("deptId")));

        EmployeeDAO.save(e);
        res.sendRedirect("admin/viewEmployees.jsp");
    }
}
