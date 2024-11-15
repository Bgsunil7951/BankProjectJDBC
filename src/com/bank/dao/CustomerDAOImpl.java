package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bank.dbconnection.ConnectionFactory;
import com.bank.dto.Customer;

public class CustomerDAOImpl implements CustomerDAO{

	private Connection con;
	
	public CustomerDAOImpl() {
		con=ConnectionFactory.requestConnection();
	}
	
	@Override
	public boolean insertCustomer(Customer c) {
		PreparedStatement ps=null;

		String query="insert into customer(name,phone,mail,pin)values(?,?,?,?)";
		int res=0;
		
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(query);
			ps.setString(1,c.getName());
			ps.setLong(2, c.getPhone());
			ps.setString(3,c.getMail());
			ps.setInt(4, c.getPin());
			res=ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(res>0) {
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}
		else {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	}

	@Override
	public Customer getCustomer(long accno, int pin) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		Customer c=new Customer();
		String query="select * from customer where acc_no=? and pin=?";
		
		try {
			ps=con.prepareStatement(query);
			
			ps.setLong(1, accno);
			ps.setInt(2, pin);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				c.setAcc_No(rs.getLong(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBalance(rs.getDouble(5));
				c.setPin(rs.getInt(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		if(c.getName()!=null) {
			return c;
		}
		else {
			return null;
		}
		
	}

	@Override
	public Customer getCustomer(long phone, String mail) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		Customer c=new Customer();
		String query="select * from customer where phone=? and mail=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, phone);
			ps.setString(2, mail);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				c.setAcc_No(rs.getLong(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBalance(rs.getDouble(5));
				c.setPin(rs.getInt(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return c;
	}

	@Override
	public Customer getCustomer(long accno) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		Customer c=new Customer();
		String query="select * from customer where acc_no=?";
		
		try {
			ps=con.prepareStatement(query);
			
			ps.setLong(1, accno);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				c.setAcc_No(rs.getLong(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBalance(rs.getDouble(5));
				c.setPin(rs.getInt(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return c;
	}

	@Override
	public List getCustomer() {
		PreparedStatement ps=null;
		ResultSet rs=null;
		Customer c=null;
		ArrayList<Customer> customer=new ArrayList<Customer>();
		String query="select * from customer";
		
		try {
			ps=con.prepareStatement(query);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				c=new Customer();
				c.setAcc_No(rs.getLong(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBalance(rs.getDouble(5));
				c.setPin(rs.getInt(6));
				customer.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return customer;
	}

	@Override
	public boolean deleteCustomer(Customer c) {
		PreparedStatement ps=null;

		String query="delete from customer where acc_no=?";
		int res=0;
		
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(query);
			ps.setLong(1, c.getAcc_No());
			
			res=ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(res>0) {
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}
		else {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		
	}

	@Override
	public boolean updateCustomer(Customer c) {
		Scanner sc =new Scanner(System.in);
		PreparedStatement ps=null;

		String query="update customer set name=?,phone=?,mail=?,balance=?,pin=? where acc_no=?";
		int res=0;
		
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(query);
			ps.setString(1,c.getName());
			ps.setLong(2, c.getPhone());
			ps.setString(3,c.getMail());
			ps.setDouble(4, c.getBalance());
			ps.setInt(5, c.getPin());
			ps.setLong(6, c.getAcc_No());
			res=ps.executeUpdate();
				
			
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(res>0) {
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}
		else {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	}

}
