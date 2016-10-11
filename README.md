# spring-boot-welcomer
#Setup & running
you need to unzip files.
To run application, you need to type: mvn spring-boot:run from the root project directory or run main class (RecruitmentTaskApplication) from your IDE
#Explanation of technology stack
Due to limited time I decided to focus on backend part of application and simplify the frontend. In real project I prefer to use AngularJS for UI and provide RESTful backend with Spring.

##Choosen technologies:
maven - for dependencies management
Spring Boot - as a framework due to profits connected with provided default configuration.
Spring Data - for communicating with DB
Spring Security - as a security layer of application
Slf4j - logging library
lombok - boilerplate code generator
jsp with taglib - for views
HTML5 with Bootstrap template(sb admin 2) and JQuery-ui for autocompleting
embeded Tomcat - as an application server
hsqldb - as in memory DB

##Futher improvments:
- due to current user service, when you edit user email, you have to log out and log in again - should be change in the future,
- add city and countries validation e.g. with Google Geolocation API
- with REST communication with AngularJS I will use OAuth authorization instead of session,
- reconfigure logging and storage log e.g. in files,
- when the number of entity increase, mapper (JMapper or Orika)should be use,
- based on other functionalities find common methods ect. and create abstract classes.


