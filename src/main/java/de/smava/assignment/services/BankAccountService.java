package de.smava.assignment.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.smava.assignment.entities.BankAccount;
import de.smava.assignment.entities.User;
import de.smava.assignment.repositories.BankAccountRepository;
import de.smava.assignment.repositories.UserRepository;

@Service
public class BankAccountService {
	
	@Autowired
	private BankAccountRepository accountRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<BankAccount> getAllBankAccounts() {
		return accountRepository.findAll();
	}
	
	public List<BankAccount> getBankAccountsForUserId(Integer userId) {
		List<BankAccount> filtered = new ArrayList<BankAccount>();
		for (BankAccount account : getAllBankAccounts()) {
			if (account.getHolder().getId().equals(userId)) {
				filtered.add(account);
			}
		}
		return filtered;
	}
	
	public void deleteBankAccount(Integer id) {
		accountRepository.deleteById(id);
	}
	
	public void addBankAccount(BankAccount bankAccount, Integer userId) {
		User user = userRepository.findById(userId);
		
		bankAccount.setHolder(user);
		
		accountRepository.create(bankAccount);
	}
	
	public void updateBankAccount(Integer userId, Integer accountId, BankAccount bankAccount) {
		BankAccount existingAccount = accountRepository.findById(accountId);
		if (existingAccount == null || !accountId.equals(bankAccount.getId())) {
			throw new RuntimeException("Invalid parameters"); // TODO proper error handling
		} else {
			bankAccount.setHolder(existingAccount.getHolder());
			accountRepository.update(bankAccount);
		}
	}
	
}