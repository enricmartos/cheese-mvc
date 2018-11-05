package com.emartos.cheesemvc.models;

//a type of class that gathers a concrete number of options
public enum CheeseType {

    //List of cheese types
    HARD ("Hard"),
    SOFT ("Soft"),
    FAKE ("Fake");

    //Once initialized we don't the fields to be changed
    private final String name;

    CheeseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
