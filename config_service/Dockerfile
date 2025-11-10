#FROM openjdk:17-jdk-slim
FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY build/libs/config_service-0.0.1-SNAPSHOT.jar app/configService.jar

ENTRYPOINT ["java", "-jar", "app/configService.jar"]
