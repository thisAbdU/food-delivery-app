# Food Delivery Application

## Overview

This is a Java-based food delivery application that provides a user interface for customers to order food and an admin interface for managing the system. The application uses PostgreSQL for data storage and JavaFX for the user interface.


## Prerequisites

- Java Development Kit (JDK) 11 or later
- Maven
- PostgreSQL database

## Setup

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/food-delivery-app.git
   cd food-delivery-app
   ```

2. Set up the PostgreSQL database:
   - Create a new database named `food_delivery`
   - Update the database connection details in `src/main/resources/application.properties`

3. Build the project:
   ```
   mvn clean install
   ```

## Running the Application

To run the application, use the following command:

```
mvn javafx:run
```

## Running Tests

To run the unit tests, use the following command:

```
mvn test
```

## Dependencies

- JavaFX
- Spring Framework
- HikariCP
- jBCrypt
- JUnit

For a complete list of dependencies, please refer to the `pom.xml` file.
