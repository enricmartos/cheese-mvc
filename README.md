# Cheese MVC

## Description

This application is a management system for a restaurant which allows you to see, edit and delete menu entries. You can add new menus as well, which are composed of several types of cheeses.

## Personal goals

- To get familiar with Spring Boot framework and learn how to perform basic CRUD operations
- To acquire experience with ORM (Object-Relational Mapping) and JPA (Java Persistence API). Specifically, One-to-Many
and Many-to-Many relationships
- To start using Thymeleaf as a front-end template engine.
- To implement custom model validations

## Stack

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

*Containerization*
- Docker-compose

## Build setup

### With Docker

- Clone this repo to your local machine.Docker-compose version must above 1.18 (Upgrade docker-compose to the latest version)[https://stackoverflow.com/questions/49839028/how-to-upgrade-docker-compose-to-latest-version]. Don't forget to restart your shell after performing all the steps.
```
# Start docker-compose

$ docker-compose up
```

This command creates the three docker containers detailed below:

- _cheese-mvc_app_1_: Main container of the Spring Boot application

- _cheese-mvc_mysql_1_: DB container

- _cheese-mvc_adminer_1_: DB management tool to interact with the MySQL DB

Adminer's credentials are the ones defined in .env file.

- Open your browser and test the application on *localhost:8086/cheese*


### Without Docker

- Clone this repo to your local machine. If you use IntelliJ as IDE, open this project there.

- MySQL (and MySQL Workbench, optionally) must be already installed in your machine. Otherwise, you will have to install them. Please notice that the default parameters (port, username and password) to enable the MySQL connection are defined on application.properties file. So, feel free to edit them in order to match one of your MySQL connections.

```
# Create the db

CREATE SCHEMA `cheese-mvc` ;
```

- Run the project as Spring Boot App

- Open your browser and test the application on *localhost:8086/cheese*

## References

I have accomplished the aforementioned goals thanks to the following course:

- [Java Skill Track Overview](https://www.youtube.com/watch?v=M1niptdxtIM&list=PLs5n5nYB22fI83_UAFbPLC-Mg9Uc6jeU4)
