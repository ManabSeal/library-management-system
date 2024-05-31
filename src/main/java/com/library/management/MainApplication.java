package com.library.management;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.library.management.model.Admin;
import com.library.management.services.AdminService;
import com.library.management.services.AdminServiceImpl;
import com.library.management.util.HibernateUtil;
import com.library.management.view.LoginScreen;

public class MainApplication {
	public static AdminService as = new AdminServiceImpl();
	static {
		try {
		    // Create an AdminInfo object
		    if(as.getAdminById(1)== null) {		    	
		    	Admin admin = new Admin(1,"admin", "4321", "NA", "NA");
		    	as.createAdmin(admin);
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		//HibernateUtil hu = new HibernateUtil();
//		int ch = 0;
//		Scanner sc = new Scanner(System.in);
//		do {
//			System.out.println("Enter your choice: ");
//			System.out.println("Press 1 to add admin");
//			System.out.println("Press 2 to search admin");
//			System.out.println("Press 3 to update admin");
//			System.out.println("Press 4 to show all admins");
//			System.out.println("Press 5 to exit");
//			ch = sc.nextInt();
//			sc.nextLine();
//			switch(ch) {
//				case 1:
//					System.out.println("Enter the admin name:");
//					String name = sc.nextLine();
//					System.out.println("Enter the admin password:");
//					String password = sc.nextLine();
//					System.out.println("Enter the admin phone number:");
//					String number = sc.nextLine();
//					System.out.println("Enter the admin address:");
//					String address = sc.nextLine();
//					int id = as.createAdmin(new Admin(name, password, number, address));
//					System.out.println("Your assigned Id is : " + id);
//				default: 
//					System.out.println("Enter a valid choice");
//			}
//		}while(ch != 5);
//	}
	public static void main(String[] args) {
		new LoginScreen();
	}
}
