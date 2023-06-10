package connection;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connector {
    public Connection koneksi;
    public Statement statement;

    public Connector() {
        try {
            // Class.forName("com.mysql.jdbc.cj.driver");
            String url = "jdbc:mysql://localhost:3306/tipsy_coffee?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String username = "root";
            String pass = "";
            koneksi = (Connection)DriverManager.getConnection(url, username, pass);
            statement = (Statement)koneksi.createStatement();
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
            JOptionPane.showMessageDialog(null, "Connection Failed!");
            System.exit(0);
        }
    }
}
