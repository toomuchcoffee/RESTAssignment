package de.smava.assignment.repositories;

import java.util.List;

import de.smava.assignment.entities.IEntity;

public interface IRepository<T extends IEntity> {
	
	void create(T entity);
	
	List<T> findAll();
	
	T findById(Integer id);

	void update(T entity);
	
	void deleteById(Integer id);

}
