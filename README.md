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

- Run the backend application:
  ```bash
  mvn spring-boot:run

#### 3. Run Frontend
- Navigate to the frontend folder of the project.
- Install dependencies using npm:
  ```bash
   npm install

- Start the frontend development server:
 ```bash
 npm start


### Usage

- Once both the backend and frontend are running, open your web browser and navigate to http://localhost:3000 to access ConversaBot.
- Use the following login credentials:
   -Email: deo@example.com
   -Password: deo@123
- Upon successful login, you can interact with the chat interface and converse with the conversational bot.
- For making a card payment Info, enter the PIN when prompted.
   - Please enter PIN... : 1111

Contributors
- Nihal Sayyad

### License

This project is licensed under the MIT License - see the LICENSE file for details.

```bash
This file contains all the instructions, usage guidelines, contributor information, and license details in a single place. Let me know if you need further modifications!




