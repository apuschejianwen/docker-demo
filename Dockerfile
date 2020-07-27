FROM myjdk:2.0.0
WORKDIR /usr/local
COPY target/docker-demo.jar /usr/local/app.jar
EXPOSE 8080
ENTRYPOINT ["java"," -jar -Duser.timezone=GMT+8"," /usr/local/app.jar"]