FROM ubuntu:latest
LABEL authors="Dev"

ENTRYPOINT ["top", "-b"]

FROM eclipse-temurin:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]