# Arquitectura2

# Run 

*Local con base en memoria
```
mvn spring-boot:run -Dspring.profiles.active=dev
```
*Local con una base MySQL
```
mvn spring-boot:run -Dspring.profiles.active=uat
```
*Producción
```
mvn spring-boot:run -Dspring.profiles.active=prod
```

# Deploy

```
mvn package
cd target
java -jar api.jar
```

#Deploy with NewRelic

```
mvn package
cd target
java -javaagent:newrelic.jar -jar -Dspring.profiles.active=[dev/uat/prod] api.jar
```

#API REST
```
localhost:8080/api/v1/
```

#Heroku Api

```
https://supermarketprices.herokuapp.com/api/v1/
```

#Tecnologias

*Java 8 
*MySQL
*Maven3
*Spring-boot
*JPA Repositories
*Hibernate
*New Relic
*Logback
*Heroku

#Entorno de desarrollo

*Ubuntu 14.04
*Eclipse Mars.1 Release (4.5.1)

