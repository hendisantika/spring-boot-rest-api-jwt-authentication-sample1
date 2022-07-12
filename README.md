# Spring Boot JWT Authentication using Spring Security

<p align="left">
In this article, I’ll explain how we can implement a JWT (JSON Web Token) based authentication layer on Spring Boot CRUD API using Spring Security. Basically this JWT authentication layer will secure the API to avoid unauthorized API access.

Technologies Going to Use,

- Java 1.8
- Spring Boot: 2.3.4.RELEASE
- Spring Security
- JPA
- MySQL
- Lombok
- Gradle
- Intellij Idea for IDE

Main topics I’m going to discuss here,

- What is JWT ?
- How Does JWT Based Authentication work with Spring Boot?
- Adding Required Dependencies
- Developing API
    - Defining API Endpoints
    - Spring Security Related Implementation
        - API User Specific API Development
        - Authentication Filter with UsernamePasswordAuthenticationFilter
            - What is the use of Authentication Filter ?
        - JWT Authorization Filter with BasicAuthenticationFilter
            - What is the use of JWT authorization Filter ?
        - Authentication User Detail Service to Read User From Database
        - Security Configuration With WebSecurityConfigurerAdapter
    - Testing API with JWT Authentication
    - More Configurations inside JWT based Authentication Layer
        - Send JWT Authentication Token in Response Body After Successful Login
        - Role Based Authentication with JWT
    - Conclusion

</p>

### What is JWT ?

JSON Web Token (JWT) is an open standard (RFC 7519) that defines a compact and self-contained way for securely
transmitting information between parties as a JSON object. This information can be verified and trusted because it is
digitally signed. JWTs can be signed using a secret (with the HMAC algorithm) or a public/private key pair using RSA or
ECDSA. – Definition from JWT.io

Basically, JWT allows us to digitally signed a way of transmitting information between parties and when tokens are
signed using public/private key pairs, the signature also certifies that only the party holding the private key is the
one that signed it. So no one can breach into the claims without the private key.

Follow official documentation for more details about JWT from [here](https://jwt.io/introduction/).

### How Does JWT Based Authentication work with Spring Boot?

Here is the sequence diagram for how JWT in action inside Spring Boot application with Spring security.

![JWT Work](img/jwt.png "JWT Work")

### Defining API Endpoints

This API is design to demonstrate a simple API that covers CRUD Operations in a library scenario where books and author
data are stored and members can burrow any book if it is available.

Additionally, Here we need two additional APIs to accomplish our authentication layer interagration.

Those are API endpoints to Register new API consume user and endpoint to Login and retrieve JWT for successful
authentication.

So our main API endpoints will be as follows:

| Endpoint    | HTTP Method    | Description                                                  |
| --- | --- |--------------------------------------------------------------|
| /api/user    | POST    | Create user to consume API.                                  |
| /login    | POST    | Request JWT token with Login request using auth credentials. |
| /api/library/book    | GET    | Read all books from database.                                |
| /api/library/book?isbn=1919    | GET    | Read book by ISBN                                            |
| /api/library/book/:id    | GET    | Read book by ID                                              |
| /api/library/book    | POST    | Register New Book                                            |
| /api/library/book/:id    | DELETE    | Remove a book                                                |
| /api/library/book/lend    | POST    | Lend a book to a member                                      |
| /api/library/member    | POST    | Register member                                              |
| /api/library/member/:id    | PATCH    | Update a member                                              |

and the base architecture will be like below:

![Flow](img/flow.png "Flow")

### Testing API with JWT Authentication

First let’s start with creating a API user with password who is allowed to generate JWT token to access other API
endpoints.

```json
curl --location --request POST 'http://localhost:8080/api/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username":"naruto",
    "password": "naruto"
}'
```

Now we have a user with the correct credentials in our database. Then we can generate an authentication token using
those credentials as below.

```json
curl -i --location --request POST 'http://localhost:8080/login' --header 'Content-Type: application/json' --data-raw '{
    "username": "naruto",
    "password": "naruto"
}'
```

Sending API request with authentication token we got from JWT authentication. Here we just needs to add authentication
token with the token prefix which is Bearer here as an Authorization header and send the request.

```json
curl --location --request POST 'http://localhost:8080/api/library/author' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdGRfYXBpX3VzZXIiLCJleHAiOjE2MDY1MDE4MjJ9.2TBlaqqmXcXUEIU97c1VuRwmJJphZTIAcOd9u6YLYSw8cBFTdJkyYGcwKOrre9TaG-0_E1kY_vqJasPCDiQTIg' \
--data-raw '{
    "firstName": "Uzumaki",
    "lastName": "Naruto"
}'
```

```json
curl --location --request POST 'http://localhost:8080/api/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username":"naruto",
    "password": "naruto",
    "role": "ADMIN"
}'
```




