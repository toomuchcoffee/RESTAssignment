package de.smava.assignment.entities;

public class BankAccount implements IEntity {
	private Integer id;
	private String iban;
	private String bic;
	private User holder;
	
	public BankAccount() {
	}

	public BankAccount(Integer id, String iban, String bic) {
		this.id = id;
		this.iban = iban;
		this.bic = bic;
	}

	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}

	public User getHolder() {
		return holder;
	}
	public void setHolder(User holder) {
		this.holder = holder;
	}

	public Integer getId() {
		return id;
	}
}
