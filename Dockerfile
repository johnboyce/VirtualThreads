FROM eclipse-temurin:21.0.1_12-jdk
MAINTAINER johnboyce@comcast.net.com
COPY ./target/virtual-threads-0.0.1-SNAPSHOT.jar virtual-threads.jar
CMD ["java","-jar","virtual-threads.jar"]
EXPOSE 3000