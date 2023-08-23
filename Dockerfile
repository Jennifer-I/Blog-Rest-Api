FROM openjdk:17-oracle
LABEL authors="decagon"
COPY target/blog-REST-API-0.0.1-SNAPSHOT.jar blog-image.jar
EXPOSE 8080
EXPOSE 5432
ENTRYPOINT ["java", "-jar", "blog-image.jar"]