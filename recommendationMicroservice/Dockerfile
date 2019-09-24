FROM openjdk:11
ADD ./target/recommendation-service-2.1.6.RELEASE.jar app.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "app.jar"]