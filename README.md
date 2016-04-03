# Arquitectura2

# Run 

mvn spring-boot:run -Dspring.profiles.active=[dev/uat]

# Deploy

mvn package
cd target
java -jar api.jar

#Deploy with NewRelic

mvn package
cd target
java -javaagent:../newrelic.jar -jar api.jar

#API REST
localhost:8080/api/v1/