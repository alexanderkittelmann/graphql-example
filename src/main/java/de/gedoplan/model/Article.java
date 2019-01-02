package de.gedoplan.model;

import io.leangen.graphql.annotations.GraphQLId;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Article {

    @Id
    @GraphQLId
    private Long id;

    private int articlenumber;
    private String name;
    private String description;
}
