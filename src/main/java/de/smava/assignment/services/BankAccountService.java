package de.smava.assignment.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.smava.assignment.entities.BankAccount;
import de.smava.assignment.entities.User;
import de.smava.assignment.repositories.BankAccountRepository;

@Service
public class BankAccountService {
	
	@Autowired
	private BankAccountRepository repository;
	
	@Autowired
	private UserService userService;
	
	public List<BankAccount> getAllBankAccounts() {
		return repository.findAll();
	}
	
	public List<BankAccount> getBankAccountsForUserId(Integer userId) {
		return getAllBankAccounts()
				.stream()
				.filter(a -> a.getHolder().getId().equals(userId))
				.collect(Collectors.toList());
	}
	
	public void deleteBankAccount(Integer id) {
		repository.deleteById(id);
	}
	
	public void addBankAccount(BankAccount bankAccount, Integer userId) {
		User user = userService.getUserForId(userId);
		
		if (user == null) {
			throw new ServiceException();
		}
		
		bankAccount.setHolder(user);
		
		repository.create(bankAccount);
	}
	
	public void updateBankAccount(Integer userId, Integer accountId, BankAccount bankAccount) {
		BankAccount existingAccount = repository.findById(accountId);
		if (existingAccount == null || !accountId.equals(bankAccount.getId())) {
			throw new ServiceException();
		} else {
			bankAccount.setHolder(existingAccount.getHolder());
			repository.update(bankAccount);
		}
	}
	
}
