Customer Creation API Implementation

This repository contains the implementation of a RESTful API for storing customer details with specific business rules. The API is designed to handle customer information according to the specified database schema and rules mentioned in the task description.

After cloning the repository check if the unit tests are passing.
The server is running at port 8082.
Please set MySQL username and password in the SpringBoot application as have been set in your system.

Use postman to test after running the spring boot application:
Sample postman commands:
1. Getting all customers - GET (http://localhost:8082/api/customers)
2. Get customer by Id - GET (http://localhost:8082/api/customers/1)
3. Update customer - PUT (http://localhost:8082/api/customers)
4. Add customer - POST (http://localhost:8082/api/customers)
5. Delete customer - DELETE (http://localhost:8082/api/customers/19)
