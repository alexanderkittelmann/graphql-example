package de.gedoplan.model;

import javax.persistence.Embeddable;

@Embeddable
public class Name {

	private String surname;
	private String firstname;

	protected Name() {
	}
	
	public Name(String surname, String firstname) {
		this.surname = surname;
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
}
