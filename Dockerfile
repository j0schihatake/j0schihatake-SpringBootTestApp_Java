FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/

RUN mvn -B -U -e clean verify

FROM openjdk:8-jre-alpine

EXPOSE 8080

WORKDIR /

COPY --from=MAVEN_BUILD /build/target/springBRMApp-1.0-SNAPSHOT.jar /

ENTRYPOINT ["java", "-jar", "springBRMApp-1.0-SNAPSHOT.jar"]