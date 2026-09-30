# BookVault
BookVault is a simple CRUD application built in Java for managing books and their related data.
This project delineates between the overall work and published editions, as well as the different authors and publishers for the different editions.

# Features
* Thymeleaf page templates, styled with Bootstrap, and using reusable fragments.
* Complete CRUD backend (currently frontend is generally limited to Retrieve, except in the case of Editions)
* H2 in-memory database
* GitHub Actions CI with automated testing on pushes and pull requests.

# Tech Stack
* Java, Spring Boot, Spring Data JPA
* Thymeleaf, Bootstrap
* Maven
* H2
* JUnit, Mockito

# Design Decisions
* **Date of Publishing**:
  Some books have a published date of a year, some are more precise with a day and month.
  Currently, I have this represented as a LocalDate object, which specifies all 3.
  Because of this, for the time being I will represent works and editions without a month or day as being published Jan 1st of the specified year.

# Getting Started
## Run the tests
Run `./mvnw test`
## Run the code

Run `./mvnw spring-boot:run`

Home page: `http://localhost:8089/home`