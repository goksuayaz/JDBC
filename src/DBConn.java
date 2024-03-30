import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;


public class DBConn {
    public static final String DB_URL = "jdbc:mysql://localhost/Company";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {
        String veriEkleme = "INSERT INTO employees(name, position, salary) VALUES(?,?,?)";

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement prep = connection.prepareStatement(veriEkleme);
            prep.setString(1,"Ayse");
            prep.setString(2,"Insan Kaynaklari");
            prep.setInt(3,15000);

            prep.executeUpdate();

            prep.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
