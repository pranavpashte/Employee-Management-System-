package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Department;
import util.DBConnection;

public class DepartmentDAO {

    // 🔹 Fetch all departments (used in addEmployee.jsp dropdown)
    public static List<Department> getAll() {

        List<Department> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT dept_id, dept_name FROM department";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Department d = new Department();
                d.setDeptId(rs.getInt("dept_id"));
                d.setDeptName(rs.getString("dept_name"));
                list.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 🔹 Add new department (optional feature)
    public static int save(Department d) {

        int status = 0;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO department(dept_name) VALUES(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, d.getDeptName());

            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // 🔹 Get department by ID (future use – edit employee)
    public static Department getById(int deptId) {

        Department d = null;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM department WHERE dept_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, deptId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                d = new Department();
                d.setDeptId(rs.getInt("dept_id"));
                d.setDeptName(rs.getString("dept_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return d;
    }
}
