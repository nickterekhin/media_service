package com.guithub.domain;

import javax.persistence.*;

@Entity
@Table(name = "collaborator")
public class Collaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;


    public Collaborator() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
