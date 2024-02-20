# Querying Objects with JPA

<img src="./public/screenshot/3_hibernate_jpa/8.png"/>

<img src="./public/screenshot/3_hibernate_jpa/9.png"/>

# [SKIPPED] Updating/Deleting an Object with JPA

* very simple, just following syntaxes

# Creating Database Tables from Java Code

* Create tables based on Java code with JPA/Hibernate annotations

## Configuration

* In spring boot configuration file: `application.properties`
  * `spring.jpa.hibernate.ddl-auto=XXX`
  <img src="./public/screenshot/3_hibernate_jpa/13.png"/>

  * If you choose `create`, when you run your app, JPA/Hibernate will **drop** tables then **create** them (yes, all data is lost)


<img src="./public/screenshot/3_hibernate_jpa/12.png"/>



