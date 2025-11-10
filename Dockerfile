FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/AWSDeployable-0.0.1-SNAPSHOT.jar AWSDeployable.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "AWSDeployable.jar"]