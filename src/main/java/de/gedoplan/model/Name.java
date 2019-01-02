package de.gedoplan.model;

import javax.persistence.Embeddable;

@Embeddable
public class Name {

    private String surname;
    private String firstname;

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
