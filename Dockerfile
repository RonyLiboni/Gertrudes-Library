FROM eclipse-temurin:11.0.16.1_1-jre-jammy
WORKDIR /gertrudes-library
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ger-library-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ger-library-app.jar"]
