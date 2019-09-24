FROM openjdk:11
ADD ./target/auth-service-2.1.6.RELEASE.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
