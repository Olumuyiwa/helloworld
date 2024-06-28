# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Copy the current target directory contents which is the jar file into the container at /app
COPY target/*.jar /app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# ENTRYPOINT ["java", "-jar", "/app.jar"]

# Run the application
CMD ["java", "-jar", "/app.jar"]