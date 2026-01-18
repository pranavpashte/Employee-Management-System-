package dao;

import java.sql.*;
import util.DBConnection;

public class AdminDAO {

    public static boolean validate(String email, String password) {
        boolean status = false;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                con.prepareStatement(
                "SELECT * FROM admin WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
