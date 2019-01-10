package de.gedoplan.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import de.gedoplan.model.Customer;

public class CustomerRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Customer> getAllCustomers() {
		return this.entityManager.createQuery("select c from Customer c", Customer.class).getResultList();
	}
	
	public Customer getCustomer(Long id) {
		return this.entityManager.find(Customer.class, id);
	}

	@Transactional
	public void saveCustomer(Customer customer) {
		this.entityManager.persist(customer);
	}
}
