package de.gedoplan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Orderposition {

    @Id
    @GeneratedValue
    private Long id;

    private int position;

    @OneToOne
    private Article article;
    
    protected Orderposition() {
	}

    public Orderposition(int position, Article article) {
        this.position = position;
        this.article = article;
    }

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
