package com.bank.App;

import java.util.Scanner;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDAOImpl;
import com.bank.dto.Customer;

public class Login {

	public static void login() {
		Scanner sc=new Scanner(System.in);
		Customer c=new Customer();
		CustomerDAO cdao=new CustomerDAOImpl();
		
		System.out.println("Enter your account number");
		long acc=sc.nextLong();
		
		System.out.println("Enetr your pin");
		int pin=sc.nextInt();
		
		c=cdao.getCustomer(acc, pin);
		
		if(c!=null ) {
			
			if(c.getAcc_No()==1100110011) {
				System.out.println("Welcome  admin "+c.getName()+"!");
				Admin.admin(c);
				
			}
			else {
				System.out.println("Login Successful!");
				App.options(c);
				
			}
			
		}
		else {
			System.out.println("Invalid account number or Pin");
		}
		
	}
}
