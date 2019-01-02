package de.gedoplan.model;

import io.leangen.graphql.annotations.GraphQLId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ordering {

    @Id
    @GraphQLId
    private Long id;

    @OneToMany
    private Set<Orderposition> orderpositionSet = new HashSet<>();

    @OneToOne
    private Customer customer;
}
