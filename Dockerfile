FROM maven:3.6.3-openjdk-11 AS BUILD_IMAGE
ENV APP_HOME=/root/dev/
WORKDIR $APP_HOME
COPY . .
RUN mvn clean package

FROM openjdk:11.0.7
WORKDIR /app/
COPY --from=BUILD_IMAGE /root/dev/target/linkstation-jar-with-dependencies.jar ./linkstation.jar
EXPOSE 8080
CMD ["java","-jar","linkstation.jar"]