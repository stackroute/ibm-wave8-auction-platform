FROM openjdk:11
ADD ./target/bidding-service-2.0.5.RELEASE.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]