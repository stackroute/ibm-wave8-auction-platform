FROM openjdk:11.0.3
ADD ./target/SpringBoot-Redis-Example-0.0.1-SNAPSHOT.jar bidding-microservice.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "bidding-microservice.jar"]