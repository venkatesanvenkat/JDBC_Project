package dao;

import model.Product;

import java.sql.*;

import ConnectionManagement.ConnectManager;

public class ProductDAO {
	
	
	public void addProduct(Product product) throws ClassNotFoundException, SQLException {
		
		
		ConnectManager conm = new ConnectManager();
		Connection con = conm.EstablishConnection();
		
		String sql_query = "insert into Product(ProductID,ProductName,MinsellQuantity,Price,Quantity) values(?,?,?,?,?);";		
		
		//it is used when the query is in run time
		PreparedStatement ps =con.prepareStatement(sql_query);
		ps.setInt(1,product.getProductID());
		ps.setString(2, product.getProductName());
		ps.setInt(3, product.getMinsellQuantity());
		ps.setInt(4, product.getPrice());
		ps.setInt(5, product.getQuantity());
		
		ps.executeUpdate();
		conm.closeConnection();
	}
	
	public void display() throws ClassNotFoundException, SQLException {
		ConnectManager conm = new ConnectManager();
		Connection con = conm.EstablishConnection();
		Statement st=con.createStatement();
		ResultSet rt=st.executeQuery("select * from product");
		System.out.println("*******************************************");
		System.out.println("-------------------------------------------");
		while(rt.next()) {	
			System.out.println(" | "+rt.getInt("ProductID") + " | " +rt.getString("ProductName") + " | " +rt.getInt("MinsellQuantity") + " | " +rt.getInt("ProductID") + " | " +rt.getInt("Price") + " | "+rt.getInt("Quantity")+" | ");
			System.out.println("-------------------------------------------");
		}
		conm.closeConnection();
		
	}
}
