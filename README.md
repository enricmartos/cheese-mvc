# Cheese MVC

## Description

This application is a restaurant management system which allows you to see, edit and delete all menus entries. You can add new
menus as well. These menus are composed of several types of cheeses.

## Personal goals

- To get familiar with Spring Boot framework and learn how to perform basic CRUD operations
- To acquire experience with ORM (Object-Relational Mapping) and JPA (Java Persistence API). Spefically, One-to-Many
and Many-to-Many relationships
- To start using Thymeleaf as a front-end template engine.
- To implement custom model validations

## Core technologies

*Front-end*
- Thymeleaf
- Bootstrap

*Back-end*
- Spring Boot
- Hibernate (as a JPA framework)

*Database*
- MySQL

*Server*
- Apache Tomcat (default embedded server provided by Spring Boot)

*Dependency management tool*
- Gradle

*IDE*
- IntelliJ IDEA

## Build setup

- Clone this repo to your local machine. If you use IntelliJ as IDE, open this project there.

- MySQL and MySQL Workbench must be already installed in your machine. Otherwise, you will have to install them. Please notice that the default parameters (port, username and password) to enable the MySQL connection are defined on application.properties file. So, feel free to edit them in order to match one of your MySQL connections.

```
# Create the db

CREATE SCHEMA `cheese-mvc` ;
```

- Run the project as Spring Boot App

- Open your browser and test the application on *localhost:8080*

## References

I have accomplished the aforementioned goals thanks to the following course:

- [Java Skill Track Overview](https://www.youtube.com/watch?v=M1niptdxtIM&list=PLs5n5nYB22fI83_UAFbPLC-Mg9Uc6jeU4)