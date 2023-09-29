## Build stage
#FROM maven:3.8.4-openjdk-17-slim AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml install -Dmaven.test.skip=true
#
## Package stage
#FROM amazoncorretto:17
#COPY --from=build /home/app/target/crud-produtos-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "/usr/local/lib/demo.jar"]
#
#
#
##FROM amazoncorretto:17
##ARG JAR_FILE=target/*.jar
##WORKDIR /opt/app
##COPY ${JAR_FILE} app.jar
##EXPOSE 8080
##ENTRYPOINT ["java", "-jar", "/app.jar"]
