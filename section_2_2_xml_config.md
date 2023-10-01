# IOC (XML configuration file)

## Spring Development Process
1. Configure your Spring Beans
```xml
<beans ...>
    <bean id="myCoach">
        <class="com.XXX">
    </bean<>>
</beans>
```

*
    * `bean id=myCoach` --> like an alias
    * `class="com.XXX"` --> fully qualified class name of implementation class

2. Create a Spring Container
    * Spring container is generally known as **Application Context**
    * Specialized Implementation
        * ClassPathXmlApplicationContext....etc

```java
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
```

3. Retrieve Beans from Spring Container
```java
Coach theCoach = context.getBean("myCoach", Coach.class);
```
(applicationContext.xml)
```xml
<bean id="myCoach">
    <class="com.luv2code.springdemo.BaseballCoach">
</bean>
```

* `myCoach` id to connectxml to getBean(...)
* `com.luv2code.springdemo.BaseballCoach` implementation class

## Dependency Injection
* Injection Types
    * Constructor Injection
    * Setter Injection

### 3.1 Development Process (Constructor Injection)

1. Define the dependency interface and class

```java
public interface FortuneService {
    public String getFortune();
}

public class HappyFortuneService implements FortuneService {
    public String getFortune() {
        return "Today is your lucky day";
    }
}
```

2. Create a constructor in your class for injections
```java
public class BaseballCoach implements Coach {
    private FortuneService FortuneService;

    public BaseballCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }
}
```

3. Configure the dependency injection in Spring config file
```xml
<!-- 1. Define dependency -->
<bean id="myFortuneService"
    class="com.luv2code.springdemo.HappyFortuneService">
</bean>

<!-- 2. Inject dependency using constructor injection -->
<bean id="myCoach"
    class="com.luv2code.springdemo.Baseballcoach">
    <constructor-arg ref="myFortuneService"/>
</bean>
```

**Behind the Scene**

<img src="./public/screenshot/4_ioc_springxml/3.png"/>

### 3.2 Development Process - Setter Injection

1. Create setter method(s) in your class for injections

<img src="./public/screenshot/4_ioc_springxml/4.png"/>

2. Configure the dependency injection in Spring config file

<img src="./public/screenshot/4_ioc_springxml/5.png"/>


<img src="./public/screenshot/4_ioc_springxml/6.png"/>

### 3.3 Injecting Literal Values

1. Create setter method(s) in your class for injections

<img src="./public/screenshot/4_ioc_springxml/7.png"/>

2. Configure the dependency injection in Spring config file

<img src="./public/screenshot/4_ioc_springxml/8.png"/>

#### 3.3.1 Injection Values from a properties file

* Want to read literals (string) from a properties file
<img src="./public/screenshot/4_ioc_springxml/9.png"/>


#### 3.3.2 Development Process

1. Create Properties File

<img src="./public/screenshot/4_ioc_springxml/10.png"/>


2. Load Properties File in Spring config file

<img src="./public/screenshot/4_ioc_springxml/11.png"/>

3. Reference values from Properties file

<img src="./public/screenshot/4_ioc_springxml/12.png"/>