# First stage: Build the application
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory inside the builder container
WORKDIR /app

# Copy the Maven project files to the container
COPY . .


# Build the application
RUN mvn -B clean package -DskipTests -e

# Second stage: Create the final image
FROM openjdk:17-jdk

# Set the working directory inside the final container
WORKDIR /app

# Copy the built JAR file from the builder stage to the final image
COPY --from=build /app/target/regis.jar regis.jar

# Make port 9524 available to the world outside this container
EXPOSE 9524

# Run the JAR file
ENTRYPOINT ["java", "-jar", "regis.jar"]
