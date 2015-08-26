package de.smava.assignment.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.smava.assignment.entities.BankAccount;
import de.smava.assignment.services.BankAccountService;

@Controller
public class BankAccountController {

	@Autowired
	private BankAccountService service;
	
	@RequestMapping(value = "/bankaccounts", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		List<BankAccount> bankAccounts = service.getAllBankAccounts();

		model.addAttribute("bankAccounts", bankAccounts);

		return "bankaccounts";
	}

	@RequestMapping(value = "/users/{userId}/bankaccounts", method = RequestMethod.GET)
	public String byUser(@PathVariable("userId") String userId, Locale locale, Model model) {

		Integer userIdInt = Integer.valueOf(userId);

		List<BankAccount> bankAccounts = service.getBankAccountsForUserId(userIdInt);

		model.addAttribute("bankAccounts", bankAccounts);

		return "bankaccounts";
	}

	@RequestMapping(value = "users/{userId}/bankaccounts", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BankAccount post(@PathVariable String userId, @RequestBody final BankAccount bankAccount) {
		Integer userIdInt = Integer.valueOf(userId);
		
		service.addBankAccount(bankAccount, userIdInt);
		
		return bankAccount;
	}

	@RequestMapping(value = "users/{userId}/bankaccounts/list", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BankAccount[] postList(@PathVariable String userId, @RequestBody final BankAccount[] bankAccounts) {
		Integer userIdInt = Integer.valueOf(userId);
		
		for (BankAccount bankAccount : bankAccounts) {
			service.addBankAccount(bankAccount, userIdInt);
		}
		
		return bankAccounts;
	}

	
	@RequestMapping(value = "users/{userId}/bankaccounts/{accountId}", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BankAccount update(
			@PathVariable String userId, @PathVariable String accountId, @RequestBody final BankAccount bankAccount) {
		Integer userIdInt = Integer.valueOf(userId);
		Integer accountIdInt = Integer.valueOf(accountId);
		
		service.updateBankAccount(userIdInt, accountIdInt, bankAccount);
		
		return bankAccount;
	}

}
