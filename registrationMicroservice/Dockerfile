FROM openjdk:11
ADD ./target/registration-service-2.1.7.RELEASE.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","app.jar"]