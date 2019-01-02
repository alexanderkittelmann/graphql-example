package de.gedoplan.persistence;

import de.gedoplan.model.Orderposition;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class OrderpositionRepository {

    @Inject
    private EntityManager entityManager;

    @GraphQLQuery(name = "orderpositions")
    public List<Orderposition> getAllCustomers() {
        return this.entityManager.createQuery("select op from Orderposition op", Orderposition.class)
                .getResultList();
    }

    @Transactional
    @GraphQLMutation(name = "createOrderposition")
    public Orderposition persistCustomer(@GraphQLArgument(name = "orderposition") Orderposition orderposition) {
        this.entityManager.persist(orderposition);
        return orderposition;
    }
}
