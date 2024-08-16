#De donde se toma la imagen
FROM openjdk:17-jdk-slim

WORKDIR /app
RUN mkdir .logs
COPY ./target/eureka-0.0.1-SNAPSHOT.jar .

EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "eureka-0.0.1-SNAPSHOT.jar"]

