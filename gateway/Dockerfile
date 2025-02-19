FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/gateway-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} gateway.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/gateway.jar"]
