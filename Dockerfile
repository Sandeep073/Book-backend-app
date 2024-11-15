FROM openjdk:21
EXPOSE 8080
ADD target/bookapplication.jar bookapplication.jar
ENTRYPOINT ["java","-jar","/bookapplication.jar"]