##Loan Repayments
##PreRequisites:
- JAVA Version 19 (openjdk:19)
- Maven Version 3.8.6
##To deploy the project (Locally):
- Clone the repository
- Navigate to the project's root directory
- Open a terminal session using Windows Terminal, GitBash or any other CLI tool

###Run The Application
- `mvn spring-boot:run`
### Package Jar
- `mvn clean package spring-boot:repackage`
#### Run the package
- `java -jar target/RepaymentAPI-0.0.1-SNAPSHOT.jar`
##Database
The application uses a h2-database instance
On startup, a local instance will be created on root application path (/data/db)
To access the console, visit: [hb console](http://localhost:8082/h2-console)

The username and passwords are defined at application.properties
Make sure the database file path is correct on the login console
### Postman Collection
[Endpoints collections](.docs/Loan Repayment API.postman_collection.json)
### Documentation UI
- The application has an embedded OpenAPI  web page showcasing all the endpoints
- To access the endpoint visit:
  [OpenAPI Documentation](http://127.0.0.1:8082/swagger-ui/index.html#/)

- For the spring doc alternative visit
  [API](http://127.0.0.1:8082/v3/api-docs)
### Database Schema
![img_1.png](img.png)

### User Action 

- customer application of the loan 
- Approval by the system
- send notifications 
- start loan repayments 
- if the loan  is short term duration less than 12 months and customer has made payment consistently for last three months
 then the customer can apply for another loan
- customer cannot have more than 3 active loans 




