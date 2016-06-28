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

Java 8
MySQL
Maven3
Spring-boot
JPA Repositories
Hibernate
New Relic
Logback + Loggly
Heroku

#Entorno de desarrollo

Ubuntu 14.04
Eclipse Mars.1 Release (4.5.1)

#Docker

Para crear una imagen de docker sera necesario ejecutar los siguientes comandos:

```
git clone https://github.com/MartinMelo/Arquitectura2.git
cd Arquitectura2
mvn package
cd ..
docker build -t <nombreDeImagen> Arquitectura2/
```
Donde claramente "<nombreDeImagen>" tiene que ser reemplazado por el nombre que le quieramos dar a la imagen.

Para correr la imagen:
```
 docker run -p 8080:8080 -t <nombreDeImagen>
```



# MongoDb

Para habilitar un ring de mongo sera necesario tener al menos 3 nodos corriendo mongod,
cada nodo puede correr de la siguiente manera(ejemplo funcional):
```
mongod --fork --port 27017 --db-path /data/db1 --smallfile
mongod --fork --port 27018 --db-path /data/db2 --smallfile
mongod --fork --port 27019 --db-path /data/db3 --smallfile
```
Una vez teniendo los 3 nodos corriendo sera necesario conectarse al que elijamos 
como nodo PRIMARY de la siguiente manera:
```
mongo --port 27017
rs.conf()
rs.initiate()
rs.conf()
rs.add("<nombreDeHost>:27018")
rs.status()
rs.add("<nombreDeHost>:27019")
rs.status()
```
Luego de esto ya tendremos nuestros 3 nodos comunicandose entre ellos.
Desde nuestro proyecto sera necesario referenciar a todos los nodos en la url
de la coneccion a la base de datos.
 
 
 
###Automatic Failover


Cuando se pierde la comunicacion del primario con los demas miembros del cluster/replica por unos pocos segundos,
se elige entre los demas mediante una votacion para ver quien sera el nuevo primario. El cual sera
el secundario con mas votos.
La version 3.2 de Mongo utiliza un protocolo mas nuevo el cual permite detectar mas rapido la falla y acelerar
la deteccion de multiples primarys.

La imagen muestra el "Trigger" de la eleccion del nuevo primary

![Modo de eleccion de nodos](https://docs.mongodb.com/manual/_images/replica-set-trigger-election.png)



En las pruebas realizadas no diferencia en el tiempo de respuesta, fue casi instantaneo el switcheo entre nodos.
El switcheo entre De Slave a Master se da cuanto el actual Master desaparece. Si el Master verdadero vuelve a la vida
este volvera a ser el Master unicamente si el Actual master(antes slave) desaparece.