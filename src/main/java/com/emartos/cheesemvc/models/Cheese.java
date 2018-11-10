package com.emartos.cheesemvc.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//This annotation says that this class
//will be stored in a db as a table
@Entity
public class Cheese {
    @Id //Id as a primary key column
    @GeneratedValue //Hibernate will create this value
    private int id;
    //Java Annotations API to validate our model
    //Spring boot will generate an error message in the view
    //if the requirements are not met
    @NotNull
    @Size(min=3, max=15)
    private String name;
    //Error message customized
    @NotNull( message="Description must not be empty")
    private String description;

    //Many cheeses can have only one specific category
    //This kind of relations must have been declared on both
    //sides
    @ManyToOne
    private Category category;

    public Cheese(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //default constructor
    //objects will be instantiated by the framework and sometimes
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category type) {
        this.category = type;
    }
}
