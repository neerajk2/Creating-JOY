# Creating-JOY
Twilio Hackathon Project

## About
This is an application that’ll bring all the individual donors as well as NGOs under one roof, to facilitate the queries raised by anyone to help the needy (being humans or animals alike). It's an integrated interface to help you help others.


## How it works
- Provision to list the queries to seek help which will include information such as query text, address along with a photograph of the being in need.
- Provision to view queries for all the visitors.
- Provision to post, like, dislike and accept the queries for registered users.
- Provision to delete a query if it reaches the maximum dislikes limit (in our case 5) and to decrease the rating of the associated user who posted. Once a user reaches a minimum rating, they’ll be removed.
- Provision to segregate queries based on categories
- Provision to view requested as well as accepted queries by the registered user.



## Features
- Interface to post and accept the queries for registered users.
- User verification using Twilio API.
- A user can act as a donor or a requestor.
- Like/Dislike and interact with queries.
- Queries posted are viewable by all the visitors.



## Tech Stack

- Frontend : HTML, CSS, Javascript, Thymeleaf, Bootstrap
- Backend : Spring Boot 
- Database : H2 Database
- Verification : Twilio Verify API

## Setup
### Requirements
 - Maven
 - Java 
 - A Twilio account - sign up

 ### Twilio Account Settings

This application should give you a ready-made starting point for writing your
own appointment reminder application. Before we begin, we need to collect
all the config values we need to run the application:

| Config&nbsp;Value | Description                                                                                                                                                  |
| :---------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Account&nbsp;Sid  | Your primary Twilio account identifier - find this [in the Console](https://www.twilio.com/console).                                                         |
| Auth&nbsp;Token   | Used to authenticate - [just like the above, you'll find this here](https://www.twilio.com/console).                                                         |
|   Service&nbsp;Sid | Create a service - [in the the twilio verify console](https://www.twilio.com/console/verify/services)
  
  

### Local Development


Set Twilio credentials using SPRING_APPLICATION_JSON properties on the command line with an environment variable. Execute this command in your terminal.
```
  export SPRING_APPLICATION_JSON='{"twilio":{
  "ACCOUNT_SID":"<YOUR_ACCOUNT_SID>" ,
  "AUTH_TOKEN": "<YOUR_AUTH_TOKEN>",
  "PATH_SERVICE_SID":"<YOUR_PATH_SERVICE_SID>" 
  }
}'
```
 
## How to execute
- After the above requirements have been met:
1.Clone this repository and cd into it
git clone [https://github.com/neerajk2/Creating-JOY.git](https://github.com/neerajk2/Creating-JOY.git)
2.Execution
 * For a linux or mac os system:
 Execute this command in your terminal
```
./mvnw spring-boot:run
   ```
or


```
  sudo apt install maven
  mvn clean spring-boot:run
```
 
* For a windows system 

     Execute this command in your cmd
 ``` 
 ./mvnw spring-boot:run
 ```
  3. Navigate to http://localhost:8080
  
  
##That's it!




## How to use 

- Download or clone the repository from github.
- Open terminal/command prompt run the commands provided in local development.
- Application will be running on the specified port.
- Open browser and go to localhost:Port_number, homepage will open.
- Press Signup button and enter your details 
     * Password must be of minimum length 8 and alphanumeric.
     * Format of phone number : CountrycodePhoneNumber
       Example : +917********9 [Country code of India : +91]	
- Receive the Otp on provided phone number.
- Enter the Otp to complete the verification process.
- Login with username and password, you’ll be redirected to home.
- To make a query click on ‘post query’. For uploading an image, you should select from the images present in 
 creating-joy/src/main/resources/static/images
- On the queries page, you can browse through all the posted queries, segregated by categories where user can like/dislike or accept a query.
- On My Queries page, you can view all your posted queries and also, queries accepted by you and number of likes/dislikes for your queries.


 

That's it!

## License

[MIT](http://www.opensource.org/licenses/mit-license.html)


## Disclaimer

No warranty expressed or implied. Software is as is.






