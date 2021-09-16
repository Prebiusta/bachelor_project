FROM gradle:7.2.0-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:11.0.12-jre-slim

EXPOSE 8181

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/bpr-service.jar

ENTRYPOINT ["java","-Dspring.profiles.active=docker", "-jar", "/app/bpr-service.jar"]