package de.smava.assignment.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.smava.assignment.db.SimpleDatastore;
import de.smava.assignment.entities.BankAccount;

@Repository
public class BankAccountRepository implements IRepository<BankAccount> {
	
	@Autowired
	private SimpleDatastore db;
	
	public List<BankAccount> findAll() {
		return new ArrayList<BankAccount>(db.getBankAccounts().values());
	}
	
	public BankAccount findById(Integer id) {
		return db.getBankAccounts().get(id);
	}
	
	public void deleteById(Integer id) {
		db.getBankAccounts().remove(id);
	}
	
	public void create(BankAccount bankAccount) {
		db.getBankAccounts().put(bankAccount.getId(), bankAccount);
	}
	
	public void update(BankAccount bankAccount) {
		BankAccount existingBankAccount = db.getBankAccounts().get(bankAccount.getId());
		if (existingBankAccount != null) {
			bankAccount.setHolder(existingBankAccount.getHolder());
			db.getBankAccounts().put(bankAccount.getId(), bankAccount);
		}
	}

}
