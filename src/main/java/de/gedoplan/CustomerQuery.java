package de.gedoplan;

import java.util.List;

import javax.inject.Inject;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import de.gedoplan.model.Customer;
import de.gedoplan.persistence.CustomerRepository;

public class CustomerQuery implements GraphQLQueryResolver {
	
	@Inject
    private CustomerRepository customerRepository;
	
	public Customer customers(Long id) {
        return customerRepository.getCustomer(id);
    }

    public List<Customer> customers() {
        return customerRepository.getAllCustomers();
    }
}
