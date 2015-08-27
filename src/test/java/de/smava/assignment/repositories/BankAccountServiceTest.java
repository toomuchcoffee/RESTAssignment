package de.smava.assignment.repositories;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import de.smava.assignment.entities.BankAccount;
import de.smava.assignment.entities.User;
import de.smava.assignment.services.BankAccountService;
import de.smava.assignment.services.ServiceException;
import de.smava.assignment.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountServiceTest {

	@Mock
	private BankAccountRepository repository;
	
	@Mock
	private UserService userService;
	
	@InjectMocks
	private BankAccountService service = new BankAccountService();
	
	@Test
	public void testAddBankAccountForExistingUser() throws Exception {
		Integer userId = 23;
		BankAccount bankAccount = new BankAccount(7, "0987654321", "TEST1234");
		when(userService.getUserForId(userId)).thenReturn(new User());
		service.addBankAccount(bankAccount, userId);
		verify(userService).getUserForId(userId);
		verify(repository).create(bankAccount);
	}
	
	@Test(expected=ServiceException.class)
	public void testAddBankAccountForNonExistingUserFails() throws Exception {
		Integer userId = 23;
		BankAccount bankAccount = new BankAccount(7, "0987654321", "TEST1234");
		when(userService.getUserForId(userId)).thenReturn(null);
		service.addBankAccount(bankAccount, userId);
		verify(userService, never()).getUserForId(userId);
		verify(repository, never()).create(bankAccount);
	}

	@Test
	public void testDeleteBankAccount() throws Exception {
		service.deleteBankAccount(7);
		verify(repository).deleteById(7);
	}
	
	@Test
	public void testGetAllBankAccounts() throws Exception {
		service.getAllBankAccounts();
		verify(repository).findAll();
	}
	
	@Test
	public void testGetBankAccountsForUserId() throws Exception {
		service.getBankAccountsForUserId(23);
		verify(repository).findAll();
	}
	
	@Test
	public void testUpdateExistingBankAccount() throws Exception {
		Integer userId = 23;
		Integer accountId = 7;
		BankAccount bankAccount = new BankAccount(accountId, "0987654321", "TEST1234");
		when(repository.findById(accountId)).thenReturn(bankAccount);
		service.updateBankAccount(userId, accountId, bankAccount);
		verify(repository).update(bankAccount);
	}
	
	@Test(expected=ServiceException.class)
	public void testUpdateNotExistingBankAccountFails() throws Exception {
		Integer userId = 23;
		Integer accountId = 7;
		BankAccount bankAccount = new BankAccount(accountId, "0987654321", "TEST1234");
		when(repository.findById(7)).thenReturn(null);
		service.updateBankAccount(userId, accountId, bankAccount);
		verify(repository, never());
	}
}
