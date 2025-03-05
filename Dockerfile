FROM amazoncorretto:21
LABEL mentainer="jaguzz98@gmail.com"
WORKDIR /app
COPY jarbuild/login-registration-app-0.0.1-SNAPSHOT.jar /app/springboot-login-registration.jar
ENTRYPOINT ["java", "-jar", "springboot-login-registration.jar"]