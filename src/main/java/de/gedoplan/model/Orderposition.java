package de.gedoplan.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import io.leangen.graphql.annotations.GraphQLId;

@Entity
public class Orderposition {

    @Id
    @GraphQLId
    private Long id;

    private int position;

    @OneToOne
    private Article article;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}    
}
