package de.gedoplan.persistence;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import de.gedoplan.model.Customer;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@RequestScoped
public class CustomerRepository {

    @Inject
    private EntityManager entityManager;

    @GraphQLQuery(name = "customers")
    public List<Customer> getAllCustomers() {
        return this.entityManager.createQuery("select c from Customer c", Customer.class)
                .getResultList();
    }

    @GraphQLQuery(name = "customer")
    public Customer getCustomer(@GraphQLArgument(name = "id") Long id) {
        return this.entityManager.find(Customer.class, id);
    }

    @Transactional
    @GraphQLMutation(name = "createCustomer")
    public Customer persistCustomer(@GraphQLArgument(name = "customer") Customer customer) {
        this.entityManager.persist(customer);
        return customer;
    }
}
