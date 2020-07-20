FROM myjdk:1
WORKDIR /usr/local
COPY target/docker-demo.jar /usr/local/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]