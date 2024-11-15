package com.bank.App;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDAOImpl;
import com.bank.dao.TransactionDAO;
import com.bank.dao.TransactionDAOImp;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;
import com.bank.dto.TransactionID;

public class Admin {

	
	public static void admin(Customer c) {
		TransactionDAO tdao=new TransactionDAOImp();
		CustomerDAO cdao=new CustomerDAOImpl();
		Scanner sc=new Scanner(System.in);
		int choice=0;
		
		System.out.println("Enter your choice: ");
		
		do {
			System.out.println("\n1. Account Data");
			System.out.println("2. Transction Data");
			System.out.println("3. Delete Customer Account");
			System.out.println("4. View Your Account");
			System.out.println("5. Go back to main menu");
			choice=sc.nextInt();
			
			switch (choice) {
			case 1: {
				List<Customer> customer=cdao.getCustomer();
				Iterator<Customer> it=customer.iterator();
					while(it.hasNext()) {
						Customer c1=it.next();
					System.out.println(c1);
						
					}
				break;
			}
			
			case 2: {
				List<Transaction> tr=tdao.getTransction();
				Iterator<Transaction> it=tr.iterator();
					while(it.hasNext()) {
					Transaction t1=it.next();
					System.out.println(t1);
						
					}
				break;
			}
			case 3: {
				System.out.println("Enter the account number to delete account");
				Customer c1=cdao.getCustomer(sc.nextLong());
				if(c.getAcc_No()!=c1.getAcc_No()) {
				c.setBalance(c.getBalance()+c1.getBalance());
				
				boolean res=cdao.updateCustomer(c);
						
				Transaction	t1=new Transaction();
				t1.setTransactionId(TransactionID.getTransactionID());
				t1.setUserAcc(c.getAcc_No());
				t1.setRecieverAcc(c1.getAcc_No());
				t1.setAmount(c1.getBalance());
				t1.setTransactionType("CREDITED");
				t1.setBalance(c.getBalance());
				
			boolean res1=tdao.insertTransaction(t1);
				
			if(res && res1) {
				System.out.println("Proceeding to delete account");
				System.out.println(c1.getAcc_No()+ " Account deleted successfully");
				cdao.deleteCustomer(c1);
			}else {
				System.out.println("Failed to delete the account");
			}
			}
			else {
				System.out.println("Can't delete the admin account");
			}
				
				break;
			}
			case 4: {
				     System.out.println("Login successful!");
				     App.options(c);
				break;
			}
			case 5: {
			
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
