package de.gedoplan;

import io.leangen.graphql.annotations.GraphQLId;
import io.leangen.graphql.annotations.GraphQLQuery;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Link implements Serializable {

    @Id
    @GraphQLId
    private Long id;

    @GraphQLQuery
    private String url;

    @GraphQLQuery
    private String description;

    public Link() {
    }

    public Link(Long id, String url, String description) {
        this.id = id;
        this.url = url;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}
