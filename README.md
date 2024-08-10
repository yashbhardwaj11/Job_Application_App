# Job Application Project

## Introduction

This project is a comprehensive Spring Boot application that covers the basics of building REST APIs, JPA, Docker, PostgreSQL, microservices, and more. Below is a detailed guide on the contents and structure of this project.

## Table of Contents

1. [Introduction to Spring Boot](#introduction-to-spring-boot)
2. [Spring Boot 101: Building Our First REST API](#spring-boot-101-building-our-first-rest-api)
3. [Level up with Spring Boot: Building Our Second Project](#level-up-with-spring-boot-building-our-second-project)
4. [Getting Started with JPA](#getting-started-with-jpa)
5. [Finishing Our Application](#finishing-our-application)
6. [Spring Boot Actuator](#spring-boot-actuator)
7. [Docker with Spring Boot](#docker-with-spring-boot)
8. [Migrating to PostgreSQL](#migrating-to-postgresql)
9. [Intro to Microservices](#intro-to-microservices)
10. [Microservices: Restructuring Our Application](#microservices-restructuring-our-application)
11. [Synchronous Communication: Inter-Service Communication Using REST Template](#synchronous-communication-inter-service-communication-using-rest-template)
12. [Service Registry and Inter-Service Communication](#service-registry-and-inter-service-communication)
13. [Working with OpenFeign](#working-with-openfeign)

## Introduction to Spring Boot

- **Basics of API**: Understand API status codes, types of API requests, and what a web framework is.
- **Introduction to Spring Framework**: Overview of Spring and Spring Boot, including architecture and auto-configuration.

## Spring Boot 101: Building Our First REST API

- **Spring Initializer**: Setting up a Spring Boot project.
- **Creating a POST Request**: Designing and understanding a basic API.
- **Postman Setup**: Testing APIs using Postman.

## Level up with Spring Boot: Building Our Second Project

- **Job Service**: Managing job-related data with various CRUD operations.
- **Challenges**: Handling IDs, deleting, updating, and managing responses.

## Getting Started with JPA

- **What is JPA?**: Understanding JPA and its data layer.
- **H2 Database**: Configuring JPA with H2 and making data persistent.

## Finishing Our Application

- **Company and Review API**: Building controllers, services, and repositories for managing companies and reviews.
- **Challenges**: Implementing various CRUD operations and relationships.

## Spring Boot Actuator

- **Introduction**: Understanding and setting up Spring Boot Actuator.
- **Endpoints**: Exploring various actuator endpoints like `/health`, `/info`, `/metrics`, etc.

## Docker with Spring Boot

- **Introduction to Docker**: Basics of Docker and containerizing a Spring Boot application.
- **Commands**: Docker commands for managing containers and images.
- **Docker Compose**: Configuring multi-container applications.

## Migrating to PostgreSQL

- **PostgreSQL**: Understanding PostgreSQL and configuring the application to use it.
- **Docker Networks**: Setting up PostgreSQL with Docker and Docker Compose.

## Intro to Microservices

- **Microservices Overview**: Understanding microservices and their benefits over monolithic architectures.

## Microservices: Restructuring Our Application

- **Refactoring**: Creating and refactoring job, company, and review services.
- **Testing**: Using Docker Compose and PostgreSQL with microservices.

## Synchronous Communication: Inter-Service Communication Using REST Template

- **REST Template**: Communicating between services using REST Template and the DTO pattern.

## Service Registry and Inter-Service Communication

- **Service Registry**: Setting up Eureka Server for service registration and discovery.
- **Load Balancing**: Using `@LoadBalanced` for inter-service communication.

## Working with OpenFeign

- **Introduction to OpenFeign**: Simplified REST client with OpenFeign.
- **Enable Feign Clients**: Configuring and using Feign clients for service communication.

## Getting Started

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yashbhardwaj11/Job_Application_App
   cd <repository-directory>
