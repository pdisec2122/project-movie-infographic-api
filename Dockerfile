FROM openjdk:11.0.6-jre-slim
COPY movieinfographic*.war movieinfographic.war
ENTRYPOINT ["java", "-jar", "movieinfographic.war"]
