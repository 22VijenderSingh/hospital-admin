#Hospital-Admin
Backend for managing patient records in a hospital

##Technologies used

1. Spring Boot Framework for core functionalities along with Hibernate for
   carrying out database operations
3. By default H2 is used as database. Any other database can be used if needed by changes in config.

##plus points
1. Log4j is used for logging any add, delete and update requests and in case of any invalid update request
2. swagger is added - Swagger2 is used, it can be opened at http://localhost:8091/swagger-ui.html.

## Run locally
1. Run `mvn clean install`
2. Run `java -jar target/hospital-admin-1.0-SNAPSHOT.war --server.port=8091`

##Swagger

To see your applications health enter url `http://localhost:8091/swagger-ui.html`
