package de.gedoplan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Ordering {

    @Id
	@GeneratedValue
    private Long id;

    @OneToMany
    private Set<Orderposition> orderpositionSet = new HashSet<>();

    @OneToOne
    private Customer customer;
    
    protected Ordering() {
	}

	public Ordering(Set<Orderposition> orderpositionSet, Customer customer) {
		this.orderpositionSet = orderpositionSet;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Orderposition> getOrderpositionSet() {
		return orderpositionSet;
	}

	public void setOrderpositionSet(Set<Orderposition> orderpositionSet) {
		this.orderpositionSet = orderpositionSet;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}    
}
