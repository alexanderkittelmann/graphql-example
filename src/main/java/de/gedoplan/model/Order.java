package de.gedoplan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Order {

    @Id
    private Long id;

    @OneToMany
    private Set<Orderposition> orderpositionSet = new HashSet<>();

    @OneToOne
    private Customer customer;
}
