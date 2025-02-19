FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/praticien-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} praticien.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/praticien.jar"]
