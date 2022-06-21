FROM openjdk:11.0.6-jre-slim
COPY target/movieinfographic-0.0.1-SNAPSHOT.war movieinfographic-0.0.1-SNAPSHOT.war
COPY application.properties application.properties
ENTRYPOINT ["java", "-jar", "movieinfographic-0.0.1-SNAPSHOT.war"]