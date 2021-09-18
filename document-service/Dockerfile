FROM gradle:7.2.0-jdk11 AS GRADLE_BUILD
COPY --chown=gradle:gradle . /build/
WORKDIR /build/
RUN gradle build --no-daemon

FROM openjdk:11
COPY --from=GRADLE_BUILD /build/build/libs/*.jar /app/document-service.jar

ENTRYPOINT ["java", "-jar", "/app/document-service.jar"]
