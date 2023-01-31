
FROM openjdk:11-jdk-slim

WORKDIR /app

COPY target/EmployeeService-0.0.1-SNAPSHOT.jar /app/employee-microservice.jar

EXPOSE 8081

CMD ["java", "-jar", "employee-microservice.jar"]

