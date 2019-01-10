package de.gedoplan;

import javax.inject.Inject;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import de.gedoplan.model.Address;
import de.gedoplan.model.Customer;
import de.gedoplan.model.Name;
import de.gedoplan.persistence.CustomerRepository;

public class CustomerMutation implements GraphQLMutationResolver{
	
	@Inject
	private CustomerRepository customerRepository;
    
    public Customer createCustomer(Long id, Name name, Address address) {
        Customer newCustomer = new Customer(id, name, address);
        customerRepository.saveCustomer(newCustomer);
        return newCustomer;
    }
}
