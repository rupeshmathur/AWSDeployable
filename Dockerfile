# Step 1: Use an official OpenJDK image
FROM openjdk:21-jdk-slim

# Step 2: Set working directory inside the container
WORKDIR /app

# Step 3: Copy the JAR from target folder into container
COPY target/AWSDeployable-0.0.1-SNAPSHOT.jar AWSDeployable.jar

# Step 4: Expose port (same as Spring Boot app port)
EXPOSE 8080

# Step 5: Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]