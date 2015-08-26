package de.smava.assignment.repositories;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import de.smava.assignment.entities.BankAccount;
import de.smava.assignment.services.BankAccountService;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountServiceTest {

	@Mock
	private BankAccountRepository accountRepository;
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private BankAccountService service = new BankAccountService();
	
	@Test
	public void testThatAddBankAccountCallsRepositoryCreate() {
		Integer userId = 23;
		BankAccount bankAccount = new BankAccount(7, "0987654321", "TEST1234");
		service.addBankAccount(bankAccount, userId);
		verify(userRepository).findById(userId);
		verify(accountRepository).create(bankAccount);
	}

}
