package Controller;//package name.
import java.sql.*;
/*Pre-build package import */
import java.util.Scanner;

/*****************************/
/*user created package import*/
import model.Login;
import model.Product;
import dao.LoginDAO;
import dao.ProductDAO;
/*****************************/

//Main class.
public class Main {
	//Main method.
	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		
		//create scanner object for get input.
		Scanner sc=new Scanner(System.in);
		
		//Create variable for selection of choice and option..
		int choice,option;
		
		//Create object for Login class and Product Class in model Package.
		Login login = new Login();
		Product product=new Product();
		LoginDAO logindao=new LoginDAO();
		ProductDAO productdao=new ProductDAO();
		
		//Create variable for get user name and the password.
		String username,password;
		
		
		do {
			System.out.println("1. Admin");
			System.out.println("2. Agent");
			System.out.println("3. Exit");
			System.out.println("*******************************************\n\n\n");
			System.out.println("Enter your choice");
			choice=sc.nextInt(); 
			System.out.println("*******************************************\n\n\n");
			switch(choice) {
				case 1:
					System.out.println("Admin Login");
					sc.nextLine();
					System.out.println("Enter your Username");
					username=sc.nextLine();
					System.out.println("Enter your Password");
					password=sc.nextLine();
					login.setUsername(username);
					login.setPassword(password);
					System.out.println("*******************************************\n\n\n");
					if(logindao.validate(login)) {
						do {
							System.out.println("1. Add Product");
							System.out.println("2. Display Product");
							System.out.println("3.Logout");
							System.out.println("*******************************************\n\n\n");
							System.out.println("Enter your option");
							option =sc.nextInt();
							System.out.println("*******************************************\n\n\n");
							switch(option) {
								case 1:
									System.out.println("Add Product");
									System.out.println("*******************************************\n\n\n");
									System.out.println("Enter the ProductID");
									int ProductID=sc.nextInt();
									product.setProductID(ProductID);
									sc.nextLine();
									System.out.println("Enter the Product Name");
									String productName=sc.nextLine();
									product.setProductName(productName);
									System.out.println("Enter the minimum sell quantity");
									int MinsellQuantity=sc.nextInt();
									product.setMinsellQuantity(MinsellQuantity);
									System.out.println("Enter the Price");
									int Price =sc.nextInt();
									product.setPrice(Price);
									System.out.println("Enter the Quantity");
									int Quantity=sc.nextInt();
									product.setQuantity(Quantity);
									productdao.addProduct(product);
									System.out.println("*******************************************\n\n\n");
									break;
								case 2:
									System.out.println("2. Display Product");
									productdao.display();
									System.out.println("*******************************************\n\n\n");
									break;
								case 3:
									System.out.println("3. Logout");
									System.out.println("*******************************************\n\n\n");
									break;
								default:
									System.out.println("Enter a valid option");
									System.out.println("*******************************************\n\n\n");
							}
						}while(option!=3);
					}
					else {
						System.out.println("Invalid Credential");
						System.out.println("*******************************************\n\n\n");
					}
					break;
				case 2:
					System.out.println("Agent Login");
					System.out.println("*******************************************\n\n\n");
					sc.nextLine();
					System.out.println("Enter your Username");
					username=sc.nextLine();
					System.out.println("Enter your Password");
					password=sc.nextLine();
					login.setUsername(username);
					login.setPassword(password);
					System.out.println("*******************************************\n\n\n");
					if(logindao.validate(login)) {
						do {
							System.out.println("1. Display Product");
							System.out.println("2.Logout");
							System.out.println("*******************************************\n\n\n");
							System.out.println("Enter your option");
							option =sc.nextInt();
							System.out.println("*******************************************\n\n\n");
							switch(option) {
								case 1:
									System.out.println("1. Display Product");
									productdao.display();
									System.out.println("*******************************************\n\n\n");
									break;
								case 2:
									System.out.println("2. Logout");
									System.out.println("*******************************************\n\n\n");
									break;
								default:
									System.out.println("Enter a valid option");
									System.out.println("*******************************************\n\n\n");
							}
						}while(option!=2);
					}
					else {
						System.out.println("Invalid Credentials");
						System.out.println("*******************************************\n\n\n");
					}
					break;
				case 3:
					System.out.println("Exit");
					System.out.println("*******************************************\n\n\n");
					break;
				default:
					System.out.println("Enter a Valid choice");
					System.out.println("*******************************************\n\n\n");
			}
		}while(choice!=3);
		sc.close();
	}

}
