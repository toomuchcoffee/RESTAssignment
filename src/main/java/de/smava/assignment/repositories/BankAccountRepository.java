package de.smava.assignment.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.smava.assignment.entities.BankAccount;
import de.smava.assignment.entities.User;

@Repository
public class BankAccountRepository implements IRepository<BankAccount> {

	@Autowired
	private UserRepository userRepository;
	
	private Map<Integer, BankAccount> bankAccounts = new HashMap<Integer, BankAccount>();
	
	@PostConstruct
	private void fillWithData() {
		User user1 = userRepository.findById(1);
		User user2 = userRepository.findById(2);

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
	
	
	
	public List<BankAccount> findAll() {
		return new ArrayList<BankAccount>(bankAccounts.values());
	}
	
	public BankAccount findById(Integer id) {
		return bankAccounts.get(id);
	}
	
	public void deleteById(Integer id) {
		bankAccounts.remove(id);
	}
	
	public void create(BankAccount bankAccount) {
		bankAccounts.put(bankAccount.getId(), bankAccount);
	}
	
	public void update(BankAccount bankAccount) {
		BankAccount existingBankAccount = bankAccounts.get(bankAccount.getId());
		if (existingBankAccount != null) {
			bankAccount.setHolder(existingBankAccount.getHolder());
			bankAccounts.put(bankAccount.getId(), bankAccount);
		}
	}
	

}
