FROM openjdk:11 as build
ARG JAR_FILE=target/*.jar
COPY target/spring-paypal-example-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]