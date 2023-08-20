FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/internal-engine-kit-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9090

CMD ["java", "-jar", "app.jar"]

#docker build -t internal-engin-kit-server:latest .

#docker run -d -p 19980:9090 -v /app/src/main/resources/db:/app/src/main/resources/db internal-engin-kit-server:latest