package de.gedoplan.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Orderposition {

    @Id
    private Long id;

    private int position;

    @OneToOne
    private Article article;
}
