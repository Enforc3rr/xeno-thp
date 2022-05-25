FROM openjdk:11
EXPOSE 8080
ADD target/XENO-THP.jar XENO-THP.jar
ENTRYPOINT ["java","-jar","/XENO-THP.jar"]