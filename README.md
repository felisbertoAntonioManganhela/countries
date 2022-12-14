
# Countries

"Countries" is a country management system with the following functionalities
* Create
* Update
* Delete
* List and Sort by properties

## Technologies
* Java 8
* Spring boot 2.7.6
* Mysql 
* AWS

## Installing and Run Local
GO to "application-dev.properties" configuration file

1 - update this line to create tables automatically  
spring.jpa.hibernate.ddl-auto=update

2 - Insert your credential  
spring.datasource.username=root  
spring.datasource.password=

3 - Create database  
create database countries_db;

4 - Remove AWS Dependencies and SecretManagerConfig

5 - Run - command line   
mvn spring-boot:run -Drun.profiles=dev

## Endpoints

### Create
POST http://localhost:8080/v1/country
```
{
    "name" : "Mozambique",
    "capital" : "Maputo",
    "region" : "Austral",
    "subregion" : "South",
    "area": 200.0
}
```

### Update
PUT http://localhost:8080/v1/country/{id}
```
{
    "name" : "Brazil",
    "capital" : "Brasilia",
    "region" : "South America",
    "subregion" : "South",
    "area": 200.0
}
```

### Delete
DELETE http://localhost:8080/v1/country/{id}

### List All and Sort
GET http://localhost:8080/v1/country?sort=region