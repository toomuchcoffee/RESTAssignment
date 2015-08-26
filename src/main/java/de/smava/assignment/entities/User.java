package de.smava.assignment.entities;

public class User implements IEntity {
	private Integer id;
	private String firstName;
	private String lastName;
	
	public User() {
	}
	
	public User(Integer id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getId() {
		return id;
	}	
}
