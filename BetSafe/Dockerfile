#syntax=docker/dockerfile:1
FROM openjdk:17-alpine3.13

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src
RUN ./mvnw install -DskipTests
CMD ["./mvnw", "-e", "spring-boot:run"]