package de.gedoplan;

import com.coxautodev.graphql.tools.GraphQLResolver;

import de.gedoplan.model.Address;
import de.gedoplan.model.Customer;
import de.gedoplan.model.Name;
import de.gedoplan.persistence.CustomerRepository;

public class CustomerMutation implements GraphQLResolver<Customer>{
	
	private final CustomerRepository customerRepository;

    public CustomerMutation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    public Customer createCustomer(Long id, Name name, Address address) {
        Customer newCustomer = new Customer(id, name, address);
        customerRepository.saveCustomer(newCustomer);
        return newCustomer;
    }
}
