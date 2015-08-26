package de.smava.assignment.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.smava.assignment.db.SimpleDatastore;
import de.smava.assignment.entities.User;

@Repository
public class UserRepository implements IRepository<User> {
	
	@Autowired
	private SimpleDatastore db;

	public List<User> findAll() {
		return new ArrayList<User>(db.getUsers().values());
	}

	public User findById(Integer id) {
		return db.getUsers().get(id);
	}

	@Override
	public void create(User user) {
		db.getUsers().put(user.getId(), user);
	}

	@Override
	public void update(User user) {
		User existingUser = findById(user.getId());
		if (existingUser != null) {
			db.getUsers().put(user.getId(), user);
		}
	}

	@Override
	public void deleteById(Integer id) {
		db.getUsers().remove(id);
	}

}
