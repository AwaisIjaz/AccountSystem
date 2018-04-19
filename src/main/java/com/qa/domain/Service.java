package com.qa.domain;

import java.util.HashMap;
 

public class Service {

	private HashMap<Integer,Account> accountMap  = new HashMap<Integer, Account>();
	
	public void addAccount(Account account) {
		if(accountMap.containsKey(account.getAccountNumber())){
			System.out.println("Account already exists");
		}
		else {
			accountMap.put(account.getAccountNumber(),account);
		}
		
		
	}
	public Account getAccount(Integer accountNumber) {
		return accountMap.get(accountNumber);
	}
	
	public void removeAccount(Account account) {
		if(accountMap.containsKey(account.getAccountNumber())) {
			accountMap.remove(account.getAccountNumber());
		}
		else {
			System.out.println("This account does not exist");
		}
	}
	public HashMap<Integer, Account> getAccountMap(){
		return accountMap;
	}
	
	public int getfirstnameDuplicate(String firstname) {
		int count = 0;
		for(Account account: accountMap.values()) {
			if(account.getFirstName().equals(firstname)) {
				++count;
			}
		}
		return count; 	
}
	public int getlastnameDuplicate(String lastname) {
		int count = 0;
		for(Account account: accountMap.values()) {
			if(account.getLastName().equals(lastname)) {
				++count;
			}
		}
		return count; 	
}
}

