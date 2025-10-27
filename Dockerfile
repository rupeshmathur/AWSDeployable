FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/AWSDeployable-0.0.1-SNAPSHOT.jar AWSDeployable.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]