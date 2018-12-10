FROM openjdk:8-alpine
ADD  target/*.jar demo-docker.jar
RUN sh -c 'touch /demo-docker.jar'
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","/demo-docker.jar"]