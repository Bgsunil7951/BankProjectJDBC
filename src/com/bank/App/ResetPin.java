package com.bank.App;

import java.util.Scanner;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDAOImpl;
import com.bank.dto.Customer;

public class ResetPin {

	public static void resetPin(Customer c) {
		Scanner sc=new Scanner(System.in);
		CustomerDAO cdao=new CustomerDAOImpl();
		
		System.out.println("Enter your mail id");
		String mailid=sc.next();
		
		System.out.println("Enter your phone");
		long phone=sc.nextLong();
		
		if(mailid.equals(c.getMail()) && phone==c.getPhone()) {
			System.out.println("Enter new PIN");
			int pin=sc.nextInt();
			System.out.println("Confirm PIN");
			int conPin=sc.nextInt();
			
			if(pin==conPin) {
				c.setPin(conPin);
				boolean res=cdao.updateCustomer(c);
				System.out.println("PIN updated successfully!");
				System.out.println("New PIN is: "+c.getPin());
				
			}
			else {
				System.out.println("PIN mismatch");
			}
		}
		else {
			System.out.println("Invalid data");
		}
		
		
	}

}
