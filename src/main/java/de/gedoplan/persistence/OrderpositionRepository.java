package de.gedoplan.persistence;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import de.gedoplan.model.Orderposition;

@RequestScoped
public class OrderpositionRepository {

    @Inject
    private EntityManager entityManager;

    public List<Orderposition> getAllCustomers() {
        return this.entityManager.createQuery("select op from Orderposition op", Orderposition.class)
                .getResultList();
    }

    @Transactional
    public Orderposition persistCustomer(Orderposition orderposition) {
        this.entityManager.persist(orderposition);
        return orderposition;
    }
}
