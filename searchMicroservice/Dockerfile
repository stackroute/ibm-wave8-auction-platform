FROM openjdk:11
ADD ./target/search-service-2.1.6.RELEASE.jar app.jar
EXPOSE 8070
ENTRYPOINT ["java", "-jar", "app.jar"]