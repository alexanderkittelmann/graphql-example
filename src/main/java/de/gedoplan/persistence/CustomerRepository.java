package de.gedoplan.persistence;

import java.util.ArrayList;
import java.util.List;

import de.gedoplan.model.Address;
import de.gedoplan.model.Customer;
import de.gedoplan.model.Name;

public class CustomerRepository {

	private List<Customer> customers;

	public CustomerRepository() {
		customers = new ArrayList<>();
		customers.add(new Customer(1L, new Name(), new Address()));
	}

	public List<Customer> getAllCustomers() {
		return customers;
	}

	public void saveCustomer(Customer customer) {
		customers.add(customer);
	}
}
