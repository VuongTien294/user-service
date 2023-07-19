FROM openjdk:8

COPY target/*.jar user-service.jar
EXPOSE 8282
ENTRYPOINT ["java","-jar","/user-service.jar"]