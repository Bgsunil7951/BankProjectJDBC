package com.bank.dto;

import java.util.Random;

public class TransactionID {
	
	public static long getTransactionID(){
		Random r=new Random();
		
		long val=r.nextLong();
		int num=0;
		
		long res=0;
		
		if(val<0) {
			val=val*(-1);
		}
		while(num<15) {
			long rem=val%10;
			res=(res*10)+rem;
			val=val/10;
			num++;
			
			
		}
		return res;
		
		
	}
}
