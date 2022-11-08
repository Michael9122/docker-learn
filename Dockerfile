FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} docker-learn-0.0.1-SNAPSHOT.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","/docker-learn-0.0.1-SNAPSHOT.jar"]
