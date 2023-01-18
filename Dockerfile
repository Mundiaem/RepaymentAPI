FROM openjdk:8-jdk-alpine
MAINTAINER ezra.com
LABEL maintainer="machariamundia@gmail.com"
CMD mvn clean package spring-boot:repackage
COPY target/RepaymentAPI-0.0.1-SNAPSHOT.jar repayment-api.jar
ENTRYPOINT ["java","-jar","/repayment-api.jar"]