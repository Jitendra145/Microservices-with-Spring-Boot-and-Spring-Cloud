## Step00-01-Introduction to Microservices
 def: Small autonomus services that work together --Sam Newman
 Microservices are
 1. Rest
 2. & small well choosen deployable units
 3. & cloud enabled
 
![alt text](https://user-images.githubusercontent.com/16119293/61320277-b88d4380-a826-11e9-9e33-f8e7b0cb1293.JPG)


While building an app we might create multiple microservices.The above pic shows that microservices are small well choosen deployable units


![alt text](https://user-images.githubusercontent.com/16119293/61320359-e70b1e80-a826-11e9-8879-7eea17a44260.JPG)

Microservices are cloud enabled means we can have multiple instances of each of the microservices. Here we have 2 instances of Microservice1,4 instances of Microservice2 etc.

## Step00-02-Chalenges With Microservices
**Challenge 1: Bounded Context**
Scenario we can have multiple microservices in place of single monolithic app.
So how can we define the required microservice and in each microservice what to do and what not to do

Answer: In new aplication it is much difficult. As we may not have complete knowledge of business to set up boundaries.
Deciding the boundaries of microservices is an evolutionary process.

**Challenge 2: Configuration Management**
We can have multiple instances and multiple environment(qa,prod etc). So It is one of the major challenge

**Challenge 3: Dynamic scale up and scale down**
Based on load microservice instances should scale up and scale down

**Challenge 4: Visibility**
If microservices are distributed over multiple instances, we got some bug.Then we have challenge to identify the instance where the bug occur.Also we need to monitor all the microservices.

**Challenge 5: Pack Of Cards**
In Microservice architecture, one service calling another, another calling other and so on. And there might be some fundamentle
microservice if that goes down then entire application will go down like a pack of cards.Therefore it is important to have fault tolerant in microservice.

## Step00-03-Introduction to Spring Cloud

To overcome the above mentioned challenges we are going to use **Spring Cloud Netflix**

Here we will discuss about each of the challenges and how Spring Cloud is going to tackle these challenges

**Configuration Management**
Spring Cloud Config Server

![alt text](https://user-images.githubusercontent.com/16119293/62832941-49074a00-bc54-11e9-9a8a-0805403f2282.JPG)

Since we have multiple instances running on multiple environments hence there will be multiple configuration to manage.
Spring Cloud config Server provide an approach where you can configure all the configuration for all the different environment of all the microservices in a Git repository. So we have a centralised configuration and "Spring Cloud Config Server" exposes this configuration to all the microservices.

So centralised configuration makes it easy to maintain the configuration.

**Dynamic Scale Up and Scale Down**
1. Naming Server(Eureka)
2. Ribbon (Client Side Load Balancing)
3. Feign (Easier REST Client)

![alt text](https://user-images.githubusercontent.com/16119293/62832957-7653f800-bc54-11e9-8b5d-c7b99023aa3f.JPG)

In the example in the above pic **CurrencyCalculationService** is talking to **CurrencyExchangeService**. Here we have multiple instances of **CurrencyExchangeService** and it is possible at any point of time a new instance can added or any instance will be removed. Now we want that **CurrencyCalculationService** distribute its load across all the instances of **CurrencyExchangeService**.
So we want to know
1. No of instances of **CurrencyExchangeService**
2. Distribute the load across all the instance of **CurrencyExchangeService**
So for the solution above proble we are going to use

1. Naming Server(Eureka)
naming Server has two important feature
A) Service Registration: All the instances of all the microservices would register with the Naming Server
B) Service Discovery: It tells about current intances of registered microservice (it can tell the current instances of **CurrencyExchangeService**)

2. Ribbon (Client Side Load Balancing)
We will use Ribbon for Client Side Load Balancing that means **CurrencyCalculationService** will host Ribbon

3. Feign (Easier REST Client)
provide mechanism to write simple RestFul client

**Visibility and Monitoring**

The solution for visibility and monitoring are
A) Zipkin Distributed Tracing

We will use **Spring Cloud Sleuth** to assign unique ID to a request across multiple component.Zipkin Distributed Tracing server will trace the request across multiple components.

B) Netflix API Gateway

One of the important feature of microservices is that they provide lots of common features for e.g. loggins,securities,analytics etc.
We don't want to implement all of these features in every microservices. **API Gateway** provide great solution to these kind of challenges. We will use **Netflix Zuul API Gateway**.

**Fault Tolerance**
Hystrix: If service is down Hystrix helps to set up default respond.

