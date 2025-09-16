FROM amazoncorretto:21.0.4-alpine3.18

WORKDIR /app

COPY target/template-backend-front-1.0.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]