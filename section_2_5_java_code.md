# 1. Java Configuration

* Instead of using XML, we will use pure Java Code

**RECAP: 3 ways of Configuring Spring Container**

<img src="./public/screenshot/8_ioc_java_code/1.png"/>

## Development Process

1. Create a Java class and annotation as @Configuration
<img src="./public/screenshot/8_ioc_java_code/2.png"/>

2. Add component scanning support: @ComponentScan (optional)
<img src="./public/screenshot/8_ioc_java_code/3.png"/>

3. Read Spring Java Configuration class
<img src="./public/screenshot/8_ioc_java_code/4.png"/>

4. Retrieve bean from Spring container
<img src="./public/screenshot/8_ioc_java_code/5.png"/>

# 2. Defining Beans with Java Code

**RECAP::**

<img src="./public/screenshot/8_ioc_java_code/6.png"/>

## 2.1 Development Process

1. Define method to expose bean
<img src="./public/screenshot/8_ioc_java_code/7.png"/>

2. Select bean dependencies 
<img src="./public/screenshot/8_ioc_java_code/8.png"/>

3. Read Spring Java configuration class
<img src="./public/screenshot/8_ioc_java_code/9.png"/>

4. Retrieve bean from Spring container
<img src="./public/screenshot/8_ioc_java_code/10.png"/>


# 2. Injecting Values from Properties file

<img src="./public/screenshot/8_ioc_java_code/11.png"/>

## Development Process
1. Create Properties
<img src="./public/screenshot/8_ioc_java_code/12.png"/>

2. Load Property File in Spring Config
<img src="./public/screenshot/8_ioc_java_code/13.png"/>

3. Reference Values from Property File
<img src="./public/screenshot/8_ioc_java_code/14.png"/>

# Good External Sources

https://www.geeksforgeeks.org/spring-configuration-annotation-with-example/
