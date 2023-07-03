# Emedlogix Service
Emedlogix is an AI enabled cloud based Next gen HCC Risk Adjustment Autocoding (CAC) application that use NLP and ML to seamlessly extract ICD-10-CM

## build
mvn clean install

## run
Run the EmedlogixServApplication.java as main

## Configuration
- Download and install the mysql db
- Download and install the Elasticsearch
- update the application.properties file for DB/Elasticsearch connections
```
server.port=8081

#spring.data.elasticsearch.cluster-nodes=localhost:9200
#spring.data.elasticsearch.cluster-name=docker-cluster


spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/emedlogix
spring.datasource.username=<user>
spring.datasource.password=<password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=false
spring.jpa.hibernate.use-new-id-generator-mappings=false

```
## External library
- Add all external libraries in the `pom.xml`
