import javax.swing.JOptionPane;
import java.sql.*;

public class Connector {
	Connection conn = null;
	
	public static Connection ConnectDatabase() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom","root","root1234");
			return conn;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			
			return null;
		}
	}

}