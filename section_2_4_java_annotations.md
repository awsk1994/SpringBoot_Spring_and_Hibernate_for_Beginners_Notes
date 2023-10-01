# 1. What are Java Annotations?

* Definition
    * Special labels/markers added to Java Classes
    * Provide meta-data about the class
    * processed at compile time or run-tiem for special processing

* Example
<img src="./public/screenshot/7_annotations/1.png"/>

* Why Spring configurations with Annotations?
    * XML configurations can be verbose
    * Solution: Configure your spring beans with annotations - to minimize XML configurations

* Scanning for Component Classes
    * Spring will scan your Java class for special annotations
    * Automatically register the beans in the Spring container

## 1.1 Deveopment Process

1. Enable component scanning in Spring Config file
<img src="./public/screenshot//7_annotations/2.png"/>

2. Add the @Component Annotation to your Java Classes
<img src="./public/screenshot//7_annotations/3.png"/>

3. Retrieve bean from Spring container
(same as before)
<img src="./public/screenshot//7_annotations/4.png"/>

2. Default Component Names

* we don't have to specify bean id, and let spring use default bean id

<img src="./public/screenshot//7_annotations/5.png"/>
<img src="./public/screenshot//7_annotations/6.png"/>

# 2. Dependency Injection

* What is Spring Wiring?
    * For dependency injection, Spring can use auto wiring
    * Spring will look for a class that matches the property
        * matches by type: class or interface
    * Spring will inject it automatically... hence it is **autowired**

* Example
    * Injecting FortuneService into a Coach Implementation
    * Spring will scan @Components
    * Anyone implements FortuneService interface??
    * If so, let's inject them; for example: happyFortuneService

* AutoWiring Injection Types
    1. Constructor Injection
    2. Setter Injection
    3. Field Injections

## 2.1 Constructor Injection
### 2.1.1 Development Process
1. Define the dependency interface and class

<img src="./public/screenshot//7_annotations/7.png"/>

2. Creates a constructor in your class for injections

<img src="./public/screenshot//7_annotations/8.png"/>

3. Configure the dependency injection @Autowired annotation

<img src="./public/screenshot//7_annotations/9.png"/>

**Big Picture**

* We can directly retrieve the Coach object from Object Factory, and the Coach's dependency is already handled

## 2.2 Setter Injection

### 2.2.1 Development Process

1. Create setter methods in your class for injections
<img src="./public/screenshot//7_annotations/10.png"/>

2. Configure the dependency injection with @Autowired Annotation
<img src="./public/screenshot//7_annotations/11.png"/>

### 2.2.2 Method Injection
* We can actually inject any method, just need to add @AutoWired

## 2.3 Field Injection

* inject dependencies by setting field values on your class directly (even for private fields)
* accomplished by using Java Reflection

### 2.3.1 Development Process

1. Configure the dependency injection with Autowired 

<img src="./public/screenshot//7_annotations/12.png"/>

# 3. Which Injection Types should you use?

* Choose a style and stay consistent in your project
* They all provide the same functionalities

# 4. AutoWiring and Qualifiers

* With AutoWiring, when you have multiple objects that matches, which one will Spring pick?
    * If Spring finds multiple matches, Spring will **throw an error**

* Now, we will need to use **Qualifier** to specify which one to use

<img src="./public/screenshot//7_annotations/13.png"/>

* can use for all 3 types of injection

# 5. Bean Scopes

* default is Singleton

<img src="./public/screenshot//7_annotations/14.png"/>
<img src="./public/screenshot//7_annotations/15.png"/>

# 6. Bean Lifecycle/Methods

## Development Process

1. Define your methods for init and destroy
<img src="./public/screenshot//7_annotations/16.png"/>

2. Add Annotations: @PostConstruct and @PreDestroy
<img src="./public/screenshot//7_annotations/17.png"/>
