FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=target/store_thing-0.0.1.jar
COPY ${JAR_FILE} thing.jar
ENTRYPOINT ["java","-jar","thing.jar", "-Dspring.config.location=classpath:application.properties"]