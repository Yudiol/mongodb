FROM openjdk:17-jdk-alpine
COPY target/*.jar mogoDB-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/mogoDB-0.0.1-SNAPSHOT.jar"]