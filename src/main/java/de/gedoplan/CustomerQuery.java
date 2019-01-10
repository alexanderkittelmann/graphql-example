package de.gedoplan;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

import de.gedoplan.model.Customer;
import de.gedoplan.persistence.CustomerRepository;

public class CustomerQuery implements GraphQLResolver<Customer> {
    private CustomerRepository customerRepository;

    public CustomerQuery(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> allCustomers() {
        return customerRepository.getAllCustomers();
    }
}
