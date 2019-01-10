package de.gedoplan.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import de.gedoplan.model.Ordering;
import de.gedoplan.model.Orderposition;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

public class OrderingRepository {

    @Inject
    private EntityManager entityManager;

    @GraphQLQuery(name = "orderings")
    public List<Ordering> getAllOrderings() {
        return this.entityManager.createQuery("select o from Ordering o", Ordering.class)
                .getResultList();
    }

    @GraphQLQuery(name = "orderposition")
    public Orderposition getOrderposition(@GraphQLArgument(name = "id") Long id) {
        return this.entityManager.find(Orderposition.class, id);
    }

    @Transactional
    @GraphQLMutation(name = "createOrdering")
    public Ordering persistCustomer(@GraphQLArgument(name = "ordering") Ordering ordering) {
        this.entityManager.persist(ordering);
        return ordering;
    }
}
