package com.bank.App;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bank.dao.TransactionDAO;
import com.bank.dao.TransactionDAOImp;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;

public class App {

	public static void options(Customer c) {
		
		TransactionDAO tdao=new TransactionDAOImp();
		Scanner sc=new Scanner(System.in);
		int choice=0;
		
		System.out.println("Welcome "+c.getName()+",");
		System.out.println("Enter your choice: ");
		
		do {
			System.out.println("\n1. Check Balance");
			System.out.println("2. Deposit Amount");
			System.out.println("3. Transfer the Amount");
			System.out.println("4. Passbook");
			System.out.println("5. Update your account");
			System.out.println("6. Reset PIN");
			System.out.println("7. Go back to main menu");
			choice=sc.nextInt();
			
			switch (choice) {
			case 1: {
				System.out.println("Your balance is: "+c.getBalance());
				break;
			}
			
			case 2: {
				Deposit.deposit(c);
				break;
			}
			case 3: {
				Transfer.transferamount(c);
				break;
			}
			case 4: {
				
				Passbook.getPassbook(c);
				break;
			}
			case 5: {
				Update.updateData(c);
				break;
			}
			case 6: {
				ResetPin.resetPin(c);
				break;
			}
			case 7: {
				System.out.println("Going back to main menu");
				break;
			}
			default:
				System.out.println("Invalid choice");
				break;
			}
			
		}while(choice!=7);
		
		
	}
}
