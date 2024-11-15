package com.bank.App;

import java.util.Scanner;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDAOImpl;
import com.bank.dto.Customer;

public class Singup {

	public static void signup() {
		Scanner sc=new Scanner(System.in);
		Customer c=new Customer();
		CustomerDAO cdao=new CustomerDAOImpl();
		
		System.out.println("<===Application form===>");
		System.out.println("Enter your name");
		c.setName(sc.next());
		
		System.out.println("Enter your phone number");
		c.setPhone(sc.nextLong());
		
		System.out.println("Enter your mail id");
		c.setMail(sc.next());
		
		System.out.println("Enter pin");
		int pin=sc.nextInt();
		
		System.out.println("Confirm pin");
		int conpin=sc.nextInt();
		
		if(pin==conpin) {
			c.setPin(conpin);
			
			boolean result=cdao.insertCustomer(c);
			if(result) {
				System.out.println("Data added successfully");
				c=cdao.getCustomer(c.getPhone(), c.getMail());
				System.out.println("Your account number is: "+c.getAcc_No());
			}
			else {
				System.out.println("failed to create a account");
			}
		}
		else {
			System.out.println("Pin mismatch");
		}
		
	}
	
}
