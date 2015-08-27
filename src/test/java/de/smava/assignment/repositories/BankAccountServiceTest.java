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
import de.smava.assignment.services.BankAccountService;
import de.smava.assignment.services.ServiceException;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountServiceTest {

	@Mock
	private BankAccountRepository accountRepository;
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private BankAccountService service = new BankAccountService();
	
	@Test
	public void testAddBankAccount() throws Exception {
		Integer userId = 23;
		BankAccount bankAccount = new BankAccount(7, "0987654321", "TEST1234");
		service.addBankAccount(bankAccount, userId);
		verify(userRepository).findById(userId);
		verify(accountRepository).create(bankAccount);
	}

	@Test
	public void testDeleteBankAccount() throws Exception {
		service.deleteBankAccount(7);
		verify(accountRepository).deleteById(7);
	}
	
	@Test
	public void testGetAllBankAccounts() throws Exception {
		service.getAllBankAccounts();
		verify(accountRepository).findAll();
	}
	
	@Test
	public void testGetBankAccountsForUserId() throws Exception {
		service.getBankAccountsForUserId(23);
		verify(accountRepository).findAll();
	}
	
	@Test
	public void testUpdateExistingBankAccount() throws Exception {
		Integer userId = 23;
		Integer accountId = 7;
		BankAccount bankAccount = new BankAccount(accountId, "0987654321", "TEST1234");
		when(accountRepository.findById(accountId)).thenReturn(bankAccount);
		service.updateBankAccount(userId, accountId, bankAccount);
		verify(accountRepository).update(bankAccount);
	}
	
	@Test(expected=ServiceException.class)
	public void testUpdateNotExistingBankAccountFails() throws Exception {
		Integer userId = 23;
		Integer accountId = 7;
		BankAccount bankAccount = new BankAccount(accountId, "0987654321", "TEST1234");
		when(accountRepository.findById(7)).thenReturn(null);
		service.updateBankAccount(userId, accountId, bankAccount);
		verify(accountRepository, never());
	}
}
