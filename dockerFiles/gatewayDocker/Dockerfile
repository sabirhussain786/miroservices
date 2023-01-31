
FROM openjdk:11-jdk-slim

WORKDIR /app

COPY target/SpringCloudGatewayApplication-0.0.1-SNAPSHOT.jar /app/spring-cloud-gateway.jar

EXPOSE 8080

CMD ["java", "-jar", "spring-cloud-gateway.jar"]

