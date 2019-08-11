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

Since we have multiple instances running on multiple environments hence there will be multiple configuration to manage.
Spring Cloud config Server provide an approach where you can configure all the configuration for all the different environment of all the microservices in a Git repository. So we have a centralised configuration and "Spring Cloud Config Server" exposes this configuration to all the microservices.

So centralised configuration makes it easy to maintain the configuration.

**Dynamic Scale Up and Scale Down**
1. Naming Server(Eureka)
2. Ribbon (Client Side Load Balancing)
3. Feign (Easier REST Client)




