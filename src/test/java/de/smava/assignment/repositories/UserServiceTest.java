package de.smava.assignment.repositories;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	
	@Mock
	private BankAccountService bankAccountService;
	
	@InjectMocks
	private UserService service = new UserService();
	
	@Test
	public void testAddUser() throws Exception {
		User user = new User(23, "firstname", "lastname");
		service.addUser(user);
		verify(userRepository).create(user);
	}

	@Test
	public void testDeleteUser() throws Exception {
		Integer userId = 23;
		List<BankAccount> bankAccounts = new ArrayList<>();
		bankAccounts.add(new BankAccount(45, "A", "B"));
		bankAccounts.add(new BankAccount(46, "X", "Y"));
		when(bankAccountService.getBankAccountsForUserId(userId)).thenReturn(bankAccounts);
		service.deleteUser(23);
		verify(bankAccountService).deleteBankAccount(45);
		verify(bankAccountService).deleteBankAccount(46);
		verify(userRepository).deleteById(23);
	}
	
	@Test
	public void testGetAllUsers() throws Exception {
		service.getAllUsers();
		verify(userRepository).findAll();
	}
	
	@Test
	public void testGetUserForId() throws Exception {
		service.getUserForId(23);
		verify(userRepository).findById(23);
	}
	
	@Test
	public void testUpdateExistingUser() throws Exception {
		Integer userId = 23;
		User user = new User(23, "firstname", "lastname");
		when(userRepository.findById(userId)).thenReturn(user);
		service.updateUser(userId, user);
		verify(userRepository).update(user);
	}
	
	@Test(expected=ServiceException.class)
	public void testUpdateNotExistingUserFails() throws Exception {
		Integer userId = 23;
		User user = new User(23, "firstname", "lastname");
		when(userRepository.findById(userId)).thenReturn(null);
		service.updateUser(userId, user);
		verify(userRepository, never()).update(user);
	}
}
