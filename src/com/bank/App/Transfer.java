package com.bank.App;

import java.util.Scanner;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDAOImpl;
import com.bank.dao.TransactionDAO;
import com.bank.dao.TransactionDAOImp;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;
import com.bank.dto.TransactionID;

public class Transfer {

	public static void transferamount(Customer c) {
		
		Scanner sc=new Scanner(System.in);
		Transaction t1=null;
		Transaction t2=null;
		CustomerDAO cdao=new CustomerDAOImpl();
		TransactionDAO tdao=new TransactionDAOImp();
		
		System.out.println("Enter the amount");
		double amount=sc.nextDouble();
		
		if(amount>0 && amount<=c.getBalance() && c.getBalance()>0) {
			
			System.out.println("Enter reciver account number");
			long reciver_accno=sc.nextLong();
			Customer reciver=cdao.getCustomer(reciver_accno);
			if(reciver!=null) {
				System.out.println("Enter PIN");
				int pin=sc.nextInt();
				if(pin==c.getPin()) {
					c.setBalance(c.getBalance()-amount);
					t1=new Transaction();
					t1.setTransactionId(TransactionID.getTransactionID());
					t1.setUserAcc(c.getAcc_No());
					t1.setRecieverAcc(reciver.getAcc_No());
					t1.setAmount(amount);
					t1.setTransactionType("DEBITED");
					t1.setBalance(c.getBalance());
					
				boolean res1=tdao.insertTransaction(t1);
				
				reciver.setBalance(reciver.getBalance()+amount);
				boolean ans=cdao.updateCustomer(reciver);
					
				t2=new Transaction();
				t2.setTransactionId(t1.getTransactionId());
				t2.setUserAcc(reciver.getAcc_No());
				t2.setRecieverAcc(c.getAcc_No());
				t2.setAmount(amount);
				t2.setTransactionType("CREDITED");
				t2.setBalance(reciver.getBalance());
				
			     boolean res2=tdao.insertTransaction(t2);
			     if(res1 && res2) {
			    	 System.out.println("Transaction successful!");
			    	 
			     }
				}
				else {
					System.out.println("Invalid pin");
				}
			}else {
				System.out.println("Account does not exit");
			}
		}
		else {
			System.out.println("Insuficent fund or enter valid amount");
		}
		
	}
}
