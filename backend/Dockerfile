# ─── Stage 1: build with Maven ─────────────────────────────────────────────────

FROM maven:3.8.7-eclipse-temurin-17 AS build

WORKDIR /workspace

# copy your POM and sources
COPY pom.xml .
COPY src ./src

# build the fat‐jar (skip tests for speed)
RUN mvn clean package -DskipTests

# ─── Stage 2: slim runtime image ──────────────────────────────────────────────

FROM eclipse-temurin:17-jdk

# create the directory where Logback will write
RUN mkdir -p /var/log/nginx-stress-lab/backend/logs \
 && chown -R 1000:1000 /var/log/nginx-stress-lab


WORKDIR /app

# pull in the built JAR
COPY --from=build /workspace/target/backend-0.0.1-SNAPSHOT.jar app.jar

# bring in your external logback config
COPY src/main/resources/logback-spring.xml .

# tell Spring Boot to use that file
ENV SPRING_LOGGING_CONFIG=file:./logback-spring.xml

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
