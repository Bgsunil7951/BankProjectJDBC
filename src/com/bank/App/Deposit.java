package com.bank.App;

import java.util.Scanner;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDAOImpl;
import com.bank.dao.TransactionDAO;
import com.bank.dao.TransactionDAOImp;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;
import com.bank.dto.TransactionID;

public class Deposit {

	public static void deposit(Customer c) {
		Scanner sc=new Scanner(System.in);
		Transaction t1=null;
		CustomerDAO cdao=new CustomerDAOImpl();
		TransactionDAO tdao=new TransactionDAOImp();
		
		System.out.println("Enter the amount to deposit");
		double amount=sc.nextDouble();
		
		
		c.setBalance(c.getBalance()+amount);
		boolean res=cdao.updateCustomer(c);
		t1=new Transaction();
		t1.setTransactionId(TransactionID.getTransactionID());
		t1.setUserAcc(c.getAcc_No());
		t1.setRecieverAcc(c.getAcc_No());
		t1.setAmount(amount);
		t1.setTransactionType("CREDITED");
		t1.setBalance(c.getBalance());
		
		
		boolean res1=tdao.insertTransaction(t1);
		
		if(res && res1) {
			
			System.out.println("Amount of Rs. "+amount+" has been added succssfully!");
			System.out.println("Your Updated Balance is Rs."+c.getBalance());
			
		}
		else {
			System.out.println("Failed to deposit! try again later");
		}
		
	}
}
