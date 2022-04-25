
# For Java 11
FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/docker-demo-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]

#ENV SPRING_DATASOURCE_URL="jdbc:mysql://mysqldb:3306/docker?createDatabaseIfNotExist=true"
#ENV SPRING_DATASOURCE_USERNAME="root"
#ENV SPRING_DATASOURCE_PASSWORD=123456

