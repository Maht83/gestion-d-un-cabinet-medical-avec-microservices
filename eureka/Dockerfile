# Image Java 8
FROM openjdk:8-jdk-alpine

# Éargument pour localiser le JAR à copier
ARG JAR_FILE=target/eureka-0.0.1-SNAPSHOT.jar

# copie du JAR dans l'image
COPY ${JAR_FILE} eureka.jar

# Exposee le port 8761 (Eureka)
EXPOSE 8761

# Démarrer l'application
ENTRYPOINT ["java", "-jar", "/eureka.jar"]
