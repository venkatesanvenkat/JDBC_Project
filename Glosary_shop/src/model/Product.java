package model;

public class Product {
	private String ProductName;
	private int ProductID,MinsellQuantity,Quantity,Price;
	public String getProductName() {
		return ProductName;
	}
	
	public void setProductName(String productName) {
		ProductName = productName;
	}
	
	public int getProductID() {
		return ProductID;
	}
	
	public void setProductID(int productID) {
		ProductID = productID;
	}
	
	public int getMinsellQuantity() {
		return MinsellQuantity;
	}
	
	public void setMinsellQuantity(int minsellQuantity) {
		MinsellQuantity = minsellQuantity;
	}
	
	public int getQuantity() {
		return Quantity;
	}
	
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	public int getPrice() {
		return Price;
	}
	
	public void setPrice(int price) {
		Price = price;
	}
	
}
