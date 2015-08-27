package de.smava.assignment.repositories;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import de.smava.assignment.entities.User;
import de.smava.assignment.services.ServiceException;
import de.smava.assignment.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	
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
		service.deleteUser(23);
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
