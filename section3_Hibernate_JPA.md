# Hibernates/JPA CRUD

## What is Hibernate?
* A framework for persisting/saving Java objects in a database
* https://hibernate.org/orm/

<img src="./public/screenshot/3_hibernate_jpa/1.png"/>

* Benefits
    * Hibernates handles all the low-level SQL
    * Minimizes the amount of JDBC code you have to develop
    * Hibernate provides the Object-to-relational mapping (ORM)

* Object-to-relational Mapping
    * mapping between java class and database schema
<img src="./public/screenshot/3_hibernate_jpa/2.png"/>


## What is JPA?
* Jakarta Persistence API (previously known as Java Persistence API)

* vendor implementations
    * Hibernate
    * EclipseLink

<img src="./public/screenshot/3_hibernate_jpa/3.png"/>


* Benefits
    * By having a standard API, you are not locked to vendor's implementation
    * Maintain portable, flexible code by coding the JPA spec
    * Can theoretically switch vendor implementation (eg. switch between Hibernate and EclipseLink)

* Saving a Java Object with JPA
```java
Student student = new Student("Paul", "Doe", "pd@pd.com");

// save it to database
entityManager.persist(theStudennt); // entityManager is a JPA Helper Object
```

* Retrieving a Java Object with JPA

```java
Student student = new Student("Paul", "Doe", "pd@pd.com");
entityManager.persist(theStudennt);

// Retrieve from the database
int theID = 1;
Student myStudent = entityManager.find(Student.class, theID);
```

* Querying for Java Objects

```java
TypedQuery<Student> theQuery = entityManager.createQuery("from Student", Student.class);
List<Student> students = theQuery.getResultList();  // Returns a list of Student objects from the database.
```

## Relationship between JDBC and JPA
* Hibernate/JPA uses JDBC for all database communications
<img src="./public/screenshot/3_hibernate_jpa/4.png"/>

## Automatic Data Source Configuration

* In Spring Boot, Hibernate is the default implementation of JPA
* EntityManager is
    * main component for creating queries.etc...
    * from JPA
* Based on configs, Spring Boot will automatically create the beans: DataSource, EntityManager 

## Steps

* Step 1: Set up Dev Environment
    * https://dev.mysql.com/downloads/mysql/
    * https://dev.mysql.com/downloads/workbench/

* Step 2: Create database and table

```sql
CREATE DATABASE  IF NOT EXISTS `student_tracker`;
USE `student_tracker`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name`varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
```

* Step 3: Set up Project
    * At spring initializr (start.spring.io), Add dependencies:
        * MySql Driver: mysql-connector-j
        * Spring Data JPA: spring-boot-starter-data-j

    * Add mysql properties to application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/student_tracker
spring.datasource.username=root
spring.datasource.password=password
```

* Step 4: Execute Maven application to check if it's running properly.
