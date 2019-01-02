package de.gedoplan.persistence;

import de.gedoplan.model.Ordering;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class OrderingRepository {

    @Inject
    private EntityManager entityManager;

    @GraphQLQuery(name = "orderings")
    public List<Ordering> getAllCustomers() {
        return this.entityManager.createQuery("select o from Ordering o", Ordering.class)
                .getResultList();
    }

    @Transactional
    @GraphQLMutation(name = "createOrdering")
    public Ordering persistCustomer(@GraphQLArgument(name = "ordering") Ordering ordering) {
        this.entityManager.persist(ordering);
        return ordering;
    }
}
