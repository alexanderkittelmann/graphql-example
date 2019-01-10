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
    
	public Article(Long id, int articlenumber, String name, String description) {
		super();
		this.id = id;
		this.articlenumber = articlenumber;
		this.name = name;
		this.description = description;
	}
    
    
}
