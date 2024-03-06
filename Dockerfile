FROM maven:3.9.6-eclipse-temurin-21-alpine AS dependencies
COPY pom.xml /build/
WORKDIR /build/
RUN mvn --batch-mode dependency:go-offline dependency:resolve-plugins

FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
COPY --from=dependencies /root/.m2 /root/.m2
COPY pom.xml /build/
COPY src /build/src
WORKDIR /build/
RUN mvn --batch-mode --fail-fast package -DskipTests

FROM eclipse-temurin:21-jre-jammy
COPY --from=build /build/target/demo-0.0.1-SNAPSHOT.jar ./demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","./demo-0.0.1-SNAPSHOT.jar"]
