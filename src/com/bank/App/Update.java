package com.bank.App;

import java.util.Scanner;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDAOImpl;
import com.bank.dto.Customer;

public class Update {

	public static void updateData(Customer c) {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		CustomerDAO cdeo=new CustomerDAOImpl();
		System.out.println("Enter your choice: ");
		
		do {
			System.out.println("\n1. Name");
			System.out.println("2. Phone");
			System.out.println("3. Mail id");
			System.out.println("4. Go back to main menu");
			choice=sc.nextInt();
			
			switch (choice) {
			case 1: {
				System.out.println("Enter new name to update");
				c.setName(sc.next());
				boolean result=cdeo.updateCustomer(c);
				
				if(result) {
					System.out.println("Name Updated Successfully!");
					System.out.println("Updated name: "+c.getName());
				}
				else {
					System.out.println("Failed to update name");
				}
				break;
			}
			
			case 2: {
				System.out.println("Enter new Phone number to update");
				c.setPhone(sc.nextLong());
				boolean result=cdeo.updateCustomer(c);
				
				if(result) {
					System.out.println("Phone number Updated Successfully!");
					System.out.println("Updated phone: "+c.getPhone());
				}
				else {
					System.out.println("Failed to update phone");
				}
				break;
			}
			case 3: {
				System.out.println("Enter new mail to update");
				c.setMail(sc.next());
				boolean result=cdeo.updateCustomer(c);
				
				if(result) {
					System.out.println("Mail Updated Successfully!");
					System.out.println("Updated mail: "+c.getMail());
				}
				else {
					System.out.println("Failed to update mail");
				}
				break;
			}
			
			case 4: {
				System.out.println("Going back to main menu");
				break;
			}
			default:
				System.out.println("Invalid choice");
				break;
			}
			
		}while(choice!=4);
		
		
	}
}
