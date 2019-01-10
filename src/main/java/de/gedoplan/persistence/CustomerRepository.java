package de.gedoplan.persistence;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import de.gedoplan.model.Customer;

@RequestScoped
public class CustomerRepository {

    @Inject
    private EntityManager entityManager;
    
    public List<Customer> getAllCustomers() {
        return this.entityManager.createQuery("select c from Customer c", Customer.class)
                .getResultList();
    }
    
    public Customer getCustomer(int id) {
        return this.entityManager.find(Customer.class, id);
    }

    @Transactional
    public Customer persistCustomer(Customer customer) {
        this.entityManager.persist(customer);
        return customer;
    }
}
