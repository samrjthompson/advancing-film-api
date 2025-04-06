# Runtime-only image using Amazon Corretto 21
FROM amazoncorretto:21-alpine

WORKDIR /app

# Copy the prebuilt JAR from your local project root
COPY advancing-film-api.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
