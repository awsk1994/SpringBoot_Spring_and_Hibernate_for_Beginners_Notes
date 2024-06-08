# Overview

## Spring Security Model
* Spring Security defines a framework for security
* Implemented using Servlet Filters in the background
* Two methods of securing an app: declarative and programmatic

## Spring Securitywith Servlet Filters
* Servlets Filtersare used to pre-process/post-process web requests
* Servlet Filters can route Web requests based on security logic
* Spring provides a bulk of security functionality wiht servlet filters

## Spring Security Overview

<img src="./public/screenshot/5_security/1.png"/>

## Security concepts

* Authentication
    * Check user id and password with credentials stored in app/db
* Authorization
    * Check to see if user has an authorized role

## Declarative Security
* Define application's security constraints inconfiguration
    * All Java config: @Configuration
* Provides separation of concerns between application code and security

## Programmatic Security
* Spring Security provides an API for custom application coding
* Provides greater customizationfor specific app requirements

## Enabling Spring Security
1. Edit pom.xml and add spring-boot-starter-security
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

2. This will automagically secure all endpoints for application

3. Now when you access your applicatoin, spring security will promtp for login. 
    * Default username: user
    * Password: check console log for password
    * Of course, this is only for testing purposes


# Basic Configuration - Overview

### Development Process
1. Create Spring Security Configuration (@Configuration)
2. Add users, passwords and roles

#### 1. Create Spring Security Configuation
```java
// File: DemoSecurityConfig.java

import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoSecurityConfig {
    // add our security configurations here 
}
```

#### Spring Security Password Storage
* In spring security, passwords are stored using a specific format
```
{id}encodedPassword
```

#### Step 2: Add users, passwords and roles
```java
@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
            .username("John")
            .password("{noop}test123")
            .roles("EMPLOYEE")
            .build()
        return new InMemoryUserDetailsManager(john)
    }
}
```

# Restrict URLs based on Roles

* General Syntax
```
requestMatchers(<< add path to match on >>)
    .hasRole(<< authorized role >>)
```
OR (specify HTTP method)
```
requestMatchers(<< add HTTP METHOD to match on >>, << add path to match on >>)
    .hasRole(<< authorized role >>)
```
OR (adding list of roles)
```
requestMatchers(<< add HTTP METHOD to match on >>, << add path to match on >>)
    .hasRole(<< list of authorized role >>)
```


## Cross Site Request Forgery

* Spring Security can protect against CSRF attacks
* Embded additional authentication data/token to all HTML forms
* On subsequent requests, web app will verify token before processing
* Primary use case is traditional web applications (HTML forms.etc)

### When to use CSRF Protection?
* The Spring Security team recommends:
    * The CSRF protection for any normal browser web requests
    * Traditional web apps with HTML forms to add/modify data
* If you are building a REST API for non-browser clients
    * you may want to disable CSRF protection
* In general, not required for stateless REST APIs
    * that use post, put, delete and/or patch


## Code
```
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(configurer ->
            configurer
                    .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("MANAGER")
    );
    // use HTTP Basic Authentication --> since we are overriding the security filter chain, we need to specify what http authentication method we are using.
    http.httpBasic(Customizer.withDefaults());

    // disable cross site request forgery (CSRF)
    http.csrf(csrf -> csrf.disable());

    return http.build();
};
```

## Potential problem with ERROR with PUT request
* If so, https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/42261704#overview


