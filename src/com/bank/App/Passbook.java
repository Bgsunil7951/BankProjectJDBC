package com.bank.App;

import java.util.Iterator;
import java.util.List;

import com.bank.dao.TransactionDAO;
import com.bank.dao.TransactionDAOImp;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class Passbook {

	public static void getPassbook(Customer c) {
		TransactionDAO tdao=new TransactionDAOImp();
		List<Transaction> tr=tdao.getTransction(c.getAcc_No());
		Iterator<Transaction> it=tr.iterator();
		
		if(tr.isEmpty()==false) {
			while(it.hasNext()) {
				Transaction t=it.next();
				System.out.println("<--------------------------------------->");
				System.out.println("Transcation ID: "+t.getTransactionId());
				System.out.println("Account Number "+t.getRecieverAcc());
				System.out.println("Amount "+t.getAmount()+" "+t.getTransactionType());
				System.out.println("Transaction Date: "+t.getTransactionDate());
				System.out.println("Account balance is: " +t.getBalance());
				System.out.println("<--------------------------------------->");
				
			}
		}
		else {
			System.out.println();
		}
		
	}
}
