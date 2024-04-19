# ConversaBot

ConversaBot is a full-stack project built with React and Spring Boot. It provides a chat interface where users can interact with a conversational bot. The frontend, developed with React, offers a user-friendly interface, while the backend, powered by Spring Boot, handles user authentication, chat message processing, and data storage.

## Getting Started

Follow these steps to set up and run the ConversaBot project on your local machine.

### Prerequisites

- MySQL database server
- Node.js
- Java Development Kit (JDK)
- Maven

### Installation

#### 1. Import Database

- Start by importing the provided database into your MySQL server. You can find the SQL dump file in the `database` folder of this repository.

#### 2. Run Backend

- Navigate to the `backend` folder of the project.
- Build the backend Spring Boot application using Maven:
  ```bash
  mvn clean install
