package com.training;

import java.util.*;

import com.training.daos.CustomerRepositoryImpl;
import com.training.model.Customer;
import com.training.utils.DbConnection;

import java.sql.*;
public class Application {

	public static void main(String[] args)  {
		
		
		Connection con = DbConnection.getOracleConnection();
	
		
		CustomerRepositoryImpl dao = new CustomerRepositoryImpl(con);
		
		int ch =2;
		try {
			
			
			if(ch==1) {
			dao.add(new Customer(3,"Magesh","mag@abc.com"));
			dao.add(new Customer(4,"Naveen","nav@abc.com"));
			}
			
			if(ch==2) {
			
			List<Customer> list = dao.findAll();
			
			for(Customer eachCustomer: list) {
				
				System.out.println(eachCustomer);
			  }
			}
		} catch (SQLException e) {

		
			 e.printStackTrace();
		}
		
		
		
	}

}
