FROM maven:3.9.1-amazoncorretto-20 as builder

COPY src /home/app/src

COPY pom.xml /home/app

RUN mvn -f /home/app/pom.xml clean test package

FROM amazoncorretto:20.0.1-al2

WORKDIR /home/app

COPY --from=builder /home/app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
