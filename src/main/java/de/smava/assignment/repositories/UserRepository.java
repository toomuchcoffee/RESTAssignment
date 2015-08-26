package de.smava.assignment.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import de.smava.assignment.entities.User;

@Repository
public class UserRepository implements IRepository<User> {

	private Map<Integer, User> users = new HashMap<Integer, User>();

	@PostConstruct
	private void fillWithData() {
		users.put(1, new User(1, "John", "Doe"));
		users.put(2, new User(2, "Foo", "Bar"));
	}

	public List<User> findAll() {
		return new ArrayList<User>(users.values());
	}

	public User findById(Integer id) {
		return users.get(id);
	}

	@Override
	public void create(User user) {
		users.put(user.getId(), user);
	}

	@Override
	public void update(User user) {
		User existingUser = findById(user.getId());
		if (existingUser != null) {
			users.put(user.getId(), user);
		}
	}

	@Override
	public void deleteById(Integer id) {
		users.remove(id);
	}

}
