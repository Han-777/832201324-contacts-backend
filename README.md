# User Management Backend

This project is a Spring Boot-based backend application for managing user data. It provides RESTful APIs to perform CRUD (Create, Read, Update, Delete) operations on user entries, allowing easy integration with frontend applications.

## 🧐 Features

- **User Management**: Add, retrieve, update, and delete user information.
- **Validation**: Input validation for user data to ensure integrity.
- **Exception Handling**: Global exception handling for better error management.
- **Cross-Origin Resource Sharing (CORS)**: Enables cross-origin requests for client applications.

## 🛠️ Technologies Used

- Spring Boot
- Spring Data JPA
- Hibernate
- Lombok (for reducing boilerplate code)
- H2 Database (or any other database of your choice)

## 💻 Installation

### Prerequisites

- Java 11 or higher
- Maven

### Clone the Repository

```bash
git clone https://github.com/your-username/repository-name.git
cd repository-name
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

You can run the application using the following command:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## 📄 API Endpoints

### User Management API

- **Create User**

  - **Endpoint**: `POST /user`
  - **Request Body**: `UserDto` (username, email, phone)
  - **Response**: User object

- **Get User by ID**

  - **Endpoint**: `GET /user/{id}`
  - **Response**: User object

- **Get All Users**

  - **Endpoint**: `GET /user`
  - **Response**: List of User objects

- **Update User**

  - **Endpoint**: `PUT /user`
  - **Request Body**: `UserDto` (userId, username, email, phone)
  - **Response**: Updated User object

- **Delete User**
  - **Endpoint**: `DELETE /user/{id}`
  - **Response**: Success message

### Example Request

#### Create User

```http
POST /user
Content-Type: application/json

{
  "userName": "John Doe",
  "userEmail": "john.doe@example.com",
  "userPhone": "1234567890"
}
```

## 🚀 Exception Handling

The application has global exception handling that captures validation errors and other runtime exceptions, returning structured error responses.

## 📫 Database

This project is configured to work with H2 database (in-memory). You can modify the `application.properties` file to connect to other databases like MySQL or PostgreSQL.

## 🤝 Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
