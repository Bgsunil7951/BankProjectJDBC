package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dbconnection.ConnectionFactory;
import com.bank.dto.Transaction;

public class TransactionDAOImp implements TransactionDAO{

	private Connection con;
	
	public TransactionDAOImp() {
		this.con=ConnectionFactory.requestConnection();
	}
	
	@Override
	public boolean insertTransaction(Transaction t) {
		PreparedStatement ps=null;
		int result=0;
		String query="INSERT INTO PASSBOOK(TRAN_ID,USER_ACC,REC_ACC,TRAN_DATE,TRAN_TYPE, AMOUNT,BALANCE)values(?,?,?,sysdate(),?,?,?)";
		
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(query);
			ps.setLong(1,t.getTransactionId());
			ps.setLong(2,t.getUserAcc());
			ps.setLong(3,t.getRecieverAcc());
			ps.setString(4, t.getTransactionType());
			ps.setDouble(5, t.getAmount());
			ps.setDouble(6, t.getBalance());
			
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result>0) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		else {
			
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		
		
	}


	@Override
	public List getTransction(long user) {
		PreparedStatement ps=null;
		Transaction t=null;
		ArrayList<Transaction> tr=new ArrayList<>();
		ResultSet rs=null;
        String query="select * from passbook where user_acc=? order by TRAN_DATE desc limit 10";
		
		try {
			ps=con.prepareStatement(query);
			
			ps.setLong(1,user);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				t=new Transaction();
				t.setTransactionId(rs.getLong(1));
				t.setUserAcc(rs.getLong(2));
				t.setRecieverAcc(rs.getLong(3));
				t.setTransactionDate(rs.getString(4));;
				t.setTransactionType(rs.getString(5));
				t.setAmount(rs.getDouble(6));
				t.setBalance(rs.getDouble(7));
				tr.add(t);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return tr;
		
	}

	@Override
	public List getTransction() {
		PreparedStatement ps=null;
		Transaction t=null;
		ArrayList<Transaction> tr=new ArrayList<>();
		ResultSet rs=null;
        String query="select * from passbook";
		
		try {
			ps=con.prepareStatement(query);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				t=new Transaction();
				t.setTransactionId(rs.getLong(1));
				t.setUserAcc(rs.getLong(2));
				t.setRecieverAcc(rs.getLong(3));
				t.setTransactionDate(rs.getString(4));;
				t.setTransactionType(rs.getString(5));
				t.setAmount(rs.getDouble(6));
				t.setBalance(rs.getDouble(7));
				tr.add(t);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return tr;
		}
}
