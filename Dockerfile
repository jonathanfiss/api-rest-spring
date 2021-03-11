FROM openjdk:11

WORKDIR /app

COPY target/spring*.jar /app/spring-app.jar

ENTRYPOINT ["java", "-jar", "spring-app.jar"]