# grpc-spring-boot-demo
A project demonstrating the implementation of a gRPC Service using Spring Boot.

This project uses the following spring-boot starter:
https://github.com/LogNet/grpc-spring-boot-starter

#### Build with maven:
```
mvn clean install
```
#### Start the server:
```
java -jar grpc-spring-boot-demo-server/target/*.jar
```
#### Run the client:
```
java -jar grpc-spring-boot-demo-client/target/*.jar
```
#### Run image directly from Docker Hub:
```sh
docker run -p 6565:6565 marknazareno/grpc-spring-boot-demo-server
```
#### Or, build the container manually:
```
cd grpc-spring-boot-demo-server
mvn docker:build
docker run marknazareno/grpc-spring-boot-demo-server
```
