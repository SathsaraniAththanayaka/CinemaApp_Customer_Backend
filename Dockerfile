FROM openjdk:8
WORKDIR /app
COPY build/libs/Customer-0.0.1-SNAPSHOT.jar .
EXPOSE 8090
CMD ["java","-jar","Customer-0.0.1-SNAPSHOT.jar"]