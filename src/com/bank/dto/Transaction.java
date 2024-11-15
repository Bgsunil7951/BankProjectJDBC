package com.bank.dto;

import java.sql.Date;



public class Transaction {

	private long transactionId;
	private long userAcc;
	private long recieverAcc;
	private String transactionDate;
	private String transactionType;
	private double amount;
	private double balance;
	
	
	
	public Transaction(long transactionId, long userAcc, long recieverAcc, String transactionDate,
			String transactionType, double amount, double balance) {
		super();
		this.transactionId = transactionId;
		this.userAcc = userAcc;
		this.recieverAcc = recieverAcc;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.amount = amount;
		this.balance = balance;
	}
	
	public Transaction() {
		
	}
	
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public long getUserAcc() {
		return userAcc;
	}
	public void setUserAcc(long userAcc) {
		this.userAcc = userAcc;
	}
	public long getRecieverAcc() {
		return recieverAcc;
	}
	public void setRecieverAcc(long recieverAcc) {
		this.recieverAcc = recieverAcc;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String date) {
		this.transactionDate = date;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", userAcc=" + userAcc + ", recieverAcc=" + recieverAcc
				+ ", transactionDate=" + transactionDate + ", transactionType=" + transactionType + ", amount=" + amount
				+ ", balance=" + balance + "]";
	}
	
	
	
	
	
	
}
