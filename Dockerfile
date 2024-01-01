FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=target/store_thing-1.0.0.jar
COPY ${JAR_FILE} thing.jar
ENTRYPOINT ["java","-jar","thing.jar", "-Dvertx.disableDnsResolver=true", "-Dspring.config.location=classpath:application.properties"]