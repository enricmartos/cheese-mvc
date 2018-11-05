package com.emartos.cheesemvc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//This anotation says that this class
//will be stored in a db as a table
@Entity
public class Cheese {
    @Id //Id as a primary key column
    @GeneratedValue //Hibernate will create this value
    private int id;
    //Java Anotations API to validate our model
    //Spring boot will generate an error message in the view
    //if the requirements are not met
    @NotNull
    @Size(min=3, max=15)
    private String name;
    //Error message customized
    @NotNull( message="Description must not be empty")
    private String description;

    private CheeseType type;

    public Cheese(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //default constructor
    //objects will be instatiated by the framework and sometimes
    //is there are many constructor it does not which is the
    //right one to be called
    public Cheese() {
    }
    //just the getter cause we don't want to change it
    public int getId() {
        return id;
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

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }
}
