package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

import java.util.*;

@Repository

public class CustomerRepository {
	@Autowired
	private JdbcTemplate template;
	public List<Customer> getAllCustomers(){
		
		String sql="select * from customer";
		
		List<Customer> custList=
				template.query(sql, BeanPropertyRowMapper.newInstance(Customer.class));
		return custList;
		
	}
	

}
