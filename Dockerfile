# Build the .jar with Maven
FROM eclipse-temurin:25-jdk-alpine AS build

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

# Create the docker image from our new .jar
FROM eclipse-temurin:25-jre-alpine AS runtime

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]