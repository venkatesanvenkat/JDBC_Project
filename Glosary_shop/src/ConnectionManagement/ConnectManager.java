package ConnectionManagement;

import java.sql.*;

public class ConnectManager {
	Connection con = null;
	public Connection EstablishConnection()throws  ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventoryproject","root","password");
		return con;
	}
		
		public void closeConnection()throws SQLException{
			con.close();
	}
}