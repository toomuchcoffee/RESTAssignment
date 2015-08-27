package de.smava.assignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.smava.assignment.entities.User;
import de.smava.assignment.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private BankAccountService bankAccountService;

	public List<User> getAllUsers() {
		return repository.findAll();
	}

	public User getUserForId(Integer id) {
		return repository.findById(id);
	}

	public void addUser(User user) {
		repository.create(user);
	}

	public void updateUser(Integer userId, User user) {
		User existingUser = repository.findById(userId);
		if (existingUser == null || !userId.equals(user.getId())) {
			throw new ServiceException();
		} else {
			repository.update(user);
		}
	}

	public void deleteUser(Integer id) {
		bankAccountService.getBankAccountsForUserId(id).stream()
				.forEach(a -> bankAccountService.deleteBankAccount(a.getId()));

		repository.deleteById(id);
	}

}
