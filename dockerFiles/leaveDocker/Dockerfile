
FROM openjdk:11-jdk-slim

WORKDIR /app

COPY target/LeaveService-0.0.1-SNAPSHOT.jar /app/leave-microservice.jar

EXPOSE 8082

CMD ["java", "-jar", "leave-microservice.jar"]

