package de.smava.assignment.db;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import de.smava.assignment.entities.BankAccount;
import de.smava.assignment.entities.User;

@Component
public class SimpleDatastore {
	private Map<Integer, User> users = new HashMap<Integer, User>();
	
	private Map<Integer, BankAccount> bankAccounts = new HashMap<Integer, BankAccount>();
	
	@PostConstruct
	private void fillWithData() {
		User user1 = new User(1, "John", "Doe");
		User user2 = new User(2, "Foo", "Bar");

		users.put(user1.getId(), user1);
		users.put(user2.getId(), user2);

		BankAccount account1 = new BankAccount(1, "123456123456123456", "ABCDEFGHIJ");
		account1.setHolder(user1);
		
		BankAccount account2 = new BankAccount(2, "123456789101112131", "AABBCCDDEE");
		account2.setHolder(user1);
		
		BankAccount account3 = new BankAccount(3, "101010101010101010", "XYZXYZXYZX");
		account3.setHolder(user2);
		
		bankAccounts.put(account1.getId(), account1);
		bankAccounts.put(account2.getId(), account2);
		bankAccounts.put(account3.getId(), account3);		
	}


	public Map<Integer, User> getUsers() {
		return users;
	}
	
	public Map<Integer, BankAccount> getBankAccounts() {
		return bankAccounts;
	}

}
