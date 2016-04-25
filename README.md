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
localhost:8080/api/v1/