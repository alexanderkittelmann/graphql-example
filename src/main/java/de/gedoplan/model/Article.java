package de.gedoplan.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Article {

    @Id
    private Long id;

    private int articlenumber;
    private String name;
    private String description;
    
    protected Article() {
	}

    public Article(Long id, int articlenumber, String name, String description) {
        this.articlenumber = articlenumber;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getArticlenumber() {
        return articlenumber;
    }

    public void setArticlenumber(int articlenumber) {
        this.articlenumber = articlenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
