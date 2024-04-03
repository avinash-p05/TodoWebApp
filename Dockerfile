FROM openjdk:21
LABEL maintainer="avinashh.site"
ADD target/TodoList-0.0.1-SNAPSHOT.jar springboot-docker-todolist.jar
ENTRYPOINT ["java","-jar","springboot-docker-todolist.jar"]