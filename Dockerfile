FROM java:8
VOLUME /tmp
ADD target/api.jar app.jar
ADD newrelic.jar newrelic.jar
ADD newrelic.yml newrelic.yml
RUN bash -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-javaagent:newrelic.jar", "-Dspring.profiles.active=dev","-jar","/app.jar"]