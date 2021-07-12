package com.training.daos;

import java.util.ArrayList;
import java.util.List;

import com.training.ifaces.CrudRepository;
import com.training.model.Customer;

import java.sql.*;
public class CustomerRepositoryImpl implements CrudRepository<Customer> {

	private Connection con;
	
	
	public CustomerRepositoryImpl(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public int add(Customer t) throws SQLException {
		
		
		String sql = "insert into customer values(?,?,?)";
		
				PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, t.getId());
		pstmt.setString(2, t.getCustomerName());
        pstmt.setString(3, t.getEmail());
        
        
        int rowAdded = pstmt.executeUpdate();
		
		return rowAdded;
	}

	@Override
	public List<Customer> findAll() throws SQLException {

		List<Customer> custList = new ArrayList<>();
		
		
       String sql = "select * from  customer";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
		
				int id =	rs.getInt("id");
				String customerName =	rs.getString("customerName");
			    String email =    rs.getString("email");
			        
			    custList.add(new Customer(id, customerName, email));
			        
				}
		
		
     	return custList;
		
	}

	@Override
	public Customer findById(int key) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(int key) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
