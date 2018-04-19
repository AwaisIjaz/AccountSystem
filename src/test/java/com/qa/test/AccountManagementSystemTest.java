package com.qa.test;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.qa.domain.Account;
import com.qa.domain.JSONUtil;
import com.qa.domain.Service;

public class AccountManagementSystemTest {
	 
	Service service;
	
	@Before
	public void setUp() {
		service = new Service();
		
	}
	

	@Test
	public void addAccountTest() {
		Account Awais = new Account("Awais","Ijaz",1);
		service.addAccount(Awais);
		Integer expected=1;
		Integer actual=service.getAccountMap().size();
		assertEquals(expected,actual);
	}
	
	@Test
	public void removeAccountTest() {
		Account Awais = new Account("Awais","Ijaz",1);
		Account Godwin = new Account("Godwin","Adeleke",2);
		service.addAccount(Awais);
		service.addAccount(Godwin);
		service.removeAccount(Godwin);
		Integer expected=1;
		Integer actual=service.getAccountMap().size();
		assertEquals(expected,actual);
		assertFalse(service.getAccountMap().containsValue(Godwin));

		
		
	}
	
	@Test
	public void getAccountTest() {
		Account Awais = new Account("Awais","Ijaz",1);
		Account Godwin = new Account("Godwin","Adeleke",2);
		service.addAccount(Awais);
		service.addAccount(Godwin);
		Account expected = Awais;
		Account actual = service.getAccount(1);
		assertEquals(expected,actual);
		
		
	}
	@Test
	public void JSONconversionTest() {
		Account Awais = new Account("Awais","Ijaz",1);
		service.addAccount(Awais);
		JSONUtil ju=new JSONUtil();
		String expected="{\"1\":{\"firstName\":\"Awais\",\"lastName\":\"Ijaz\",\"accountNumber\":1}}";
		String actual=ju.getJSONForObject(service.getAccountMap());
		System.out.println(ju.getJSONForObject(service.getAccountMap()));
		assertEquals(expected,actual);
	}
	
}
