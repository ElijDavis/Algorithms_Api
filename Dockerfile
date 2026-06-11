# --- Stage 1: Build Environment ---
# Pulls a temporary image containing Maven and Java 21 to compile your code
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder
WORKDIR /app

# Copy your maven configuration file first to leverage layer caching
COPY pom.xml ./

# Copy your actual source code folder
COPY src ./src

# Prevent Maven from thrashing CPU/RAM by limiting heap memory and using a low-overhead GC
ENV MAVEN_OPTS="-Xmx512m -XX:+UseSerialGC"

# Compile the source code in non-interactive batch mode (-B) and skip tests
RUN mvn clean package -B -DskipTests

# --- Stage 2: Minimal Production Runtime ---
# Drops the heavy compiler tools and uses a light runtime environment
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Copy the built jar from the temporary builder stage above
COPY --from=builder /app/target/*.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Execute the application
ENTRYPOINT ["java", "-jar", "app.jar"]