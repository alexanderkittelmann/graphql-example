package de.gedoplan.persistence;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import de.gedoplan.model.Order;

@RequestScoped
public class OrderingRepository {

    @Inject
    private EntityManager entityManager;

    public List<Order> getAllCustomers() {
        return this.entityManager.createQuery("select o from Ordering o", Order.class)
                .getResultList();
    }

    @Transactional
    public Order persistCustomer(Order ordering) {
        this.entityManager.persist(ordering);
        return ordering;
    }
}
