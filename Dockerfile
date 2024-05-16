FROM maven:3.9.6-eclipse-temurin-21 AS build
RUN mvn --version
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

FROM maven:3.9.6-eclipse-temurin-21
WORKDIR /app
COPY --from=build /app/target/suitespotserver-0.0.1-SNAPSHOT.jar ./suitespotserver-aws.jar
EXPOSE 8080
CMD ["java", "-jar", "suitespotserver-aws.jar"]