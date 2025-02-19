FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/patient-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} patient.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/patient.jar"]
