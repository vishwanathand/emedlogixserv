# Emedlogix Service

## build
mvn clean install

## run
Run the EmedlogixServApplication.java as main

## Configuration
- Donwload and install the mongo db from here [download](https://www.mongodb.com/try/download/community-kubernetes-operator)
- update the application.properties file for mongo connections
```
#spring.data.mongodb.uri=mongodb://localhost:27017/roomlist
#spring.data.mongodb.database=roomlist

server.port=8081

#spring.data.elasticsearch.cluster-nodes=172.17.0.2:9200
#spring.data.elasticsearch.cluster-name=docker-cluster


spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/emedlogix
spring.datasource.username=root
spring.datasource.password=maha
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=false
spring.jpa.hibernate.use-new-id-generator-mappings=false

```
## External library
- Add all external libraries in the `pom.xml`
