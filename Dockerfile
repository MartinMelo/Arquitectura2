FROM java:8
VOLUME /tmp
ADD target/api.jar app.jar
ADD newrelic.jar newrelic.jar
ADD newrelic.yml newrelic.yml
RUN echo deb http://apt.newrelic.com/debian/ newrelic non-free >> /etc/apt/sources.list.d/newrelic.list
RUN wget -O- https://download.newrelic.com/548C16BF.gpg | apt-key add -
RUN apt-get update
RUN apt-get install newrelic-sysmond
RUN nrsysmond-config --set license_key=bd2918ae06fb6a3409a7f9e7337d98d619f0373a
RUN /etc/init.d/newrelic-sysmond start
RUN bash -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-javaagent:newrelic.jar", "-Dspring.profiles.active=docker","-jar","/app.jar"]