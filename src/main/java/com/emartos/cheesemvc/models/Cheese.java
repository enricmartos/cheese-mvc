package com.emartos.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cheese {

    //Java Anotations API to validate our model
    //Spring boot will generate an error message in the view
    //if the requirements are not met
    @NotNull
    @Size(min=3, max=15)
    private String name;
    //Error message customized
    @NotNull( message="Description must not be empty")
    private String description;
    private int cheeseId;
    //This field will belong to all instances of the class
    private static int nextId = 1;

    public Cheese(String name, String description) {
        this(); //call the default constructor
        this.name = name;
        this.description = description;
    }

    //default constructor
    //objects will be instatiated by the framework and sometimes
    //is there are many constructor it does not which is the
    //right one to be called
    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
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
