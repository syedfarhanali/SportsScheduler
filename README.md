# ======== Problem Statement =======
Build a RESTful service that generates the round robin schedule for tournament
- Details deliberately left out for security

# ======== Solution =======

# Frameworks used
- Spring MVC
- JPA with Hibernate
- jQuery for frontend js framework
- Bootstrap css framework
- Mysql database.
- jquery plugin for internationalization

# Step-1: Clone, Build and Run
- Clone GIT Repository
- Create database schema using script in src/main/resources/database/seed_data.sql
- Run mvn clean install to generate jar
- java -jar --PATH-TO-JAR
- Home URL : http://localhost:8085

# ======== Future Scope =======
- Display list of saved tournaments.
- Add Spring security for Authentication/Authorization
- Combine and Minimize the static code
- Adding Caching for already generated tournaments
- Encrypt database password.
- Add algorithm for next rounds of the tournament.
- Containerize the application using Docker
- Use Frontend frameworks like React/Angular for better experience
- Add documentation for important methods
