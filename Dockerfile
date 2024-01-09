FROM openjdk:17-jdk-alpine
MAINTAINER com.hugoalexandremf
COPY ./target/rest-api-demo-0.0.1-SNAPSHOT.jar rest-api-demo.jar
ENTRYPOINT ["java","-jar","/rest-api-demo-0.0.1-SNAPSHOT.jar"]
