package dao;

import java.sql.*;
import java.util.*;
import model.Employee;
import util.DBConnection;

public class EmployeeDAO {

    // ADD EMPLOYEE
    public static int save(Employee e) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO employee(name,email,salary,role,dept_id) VALUES(?,?,?,?,?)"
            );
            ps.setString(1, e.getName());
            ps.setString(2, e.getEmail());
            ps.setDouble(3, e.getSalary());
            ps.setString(4, e.getRole());
            ps.setInt(5, e.getDeptId());

            status = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    // VIEW ALL EMPLOYEES
    public static List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM employee");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee e = new Employee();
                e.setEmpId(rs.getInt("emp_id"));
                e.setName(rs.getString("name"));
                e.setEmail(rs.getString("email"));
                e.setSalary(rs.getDouble("salary"));
                e.setRole(rs.getString("role"));
                e.setDeptId(rs.getInt("dept_id"));
                list.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
