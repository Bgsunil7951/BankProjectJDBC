package com.bank.App;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDAOImpl;
import com.bank.dto.Customer;

public class Welcome {
	
	
	
	
	public static void main(String[] args) {
		Customer c=new Customer();
		CustomerDAO cdao= new CustomerDAOImpl();
		Scanner sc=new Scanner(System.in);
		int choice=0;
		System.out.println("<====Welcome to New Bank====>");
		do{
			System.out.println("\n1. Customer Login");
			System.out.println("2. Create Customer");
			System.out.println("3. Exit");
		    choice =sc.nextInt();
		    switch (choice) {
			case 1: {
				Login.login();
				break;
			
			}
			case 2:{
				Singup.signup();
				break;
			}
			
			case 3:{
				System.err.println("Thank you visit again");
				break;
			}
//			case 4:{
//				List<Customer> costomer=cdao.getCustomer();
//				Iterator<Customer> it=costomer.iterator();
//				while(it.hasNext()) {
//					Customer c1=it.next();
//					System.out.println(c1);
//				}
//				break;
//			}
			default:
				System.out.println("Invalid choice");
				break;
			}
			
		}while(choice!=3);
		
		
	}
}
