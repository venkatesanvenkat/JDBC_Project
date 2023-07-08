package dao;

import model.Login;
import ConnectionManagement.ConnectManager;
import java.sql.*;

public class LoginDAO {
	public boolean validate(Login login) throws ClassNotFoundException,SQLException {
		String username=login.getUsername(),password=login.getPassword();
		ConnectManager conm =new ConnectManager();
		Connection con =conm.EstablishConnection();
		Statement st=con.createStatement();
		ResultSet rt=st.executeQuery("select * from login");
		while(rt.next()) {	
			if(username.equals(rt.getString("username"))&& password.equals(rt.getString("password"))) {
				conm.closeConnection();
				return true;
			}
		}
		conm.closeConnection();
		return false;
	}
}
