package de.gedoplan.model;

import io.leangen.graphql.annotations.GraphQLId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Orderposition {

    @Id
    @GraphQLId
    private Long id;

    private int position;

    @OneToOne
    private Article article;
}
