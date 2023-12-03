FROM openjdk:17-jdk-alpine
EXPOSE 5500
ADD target/Spring_Boot_Course_Project_Money_Transfer_Service-0.0.1-SNAPSHOT.jar transfer.jar
CMD ["java","-jar","/transfer.jar"]