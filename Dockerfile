#FROM openjdk:17-jdk-slim
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY build/libs/Wallet_service_lesson-0.0.1-SNAPSHOT.jar app/WalletServiceLesson.jar

ENTRYPOINT ["java", "-jar", "app/WalletServiceLesson.jar"]
