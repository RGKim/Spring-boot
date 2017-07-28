FROM java:8
EXPOSE 8082
ADD /target/user-microservice-server-0.0.1.jar user-microservice-server.jar
ENTRYPOINT [ "java", "-jar", "user-microservice-server.jar" ]