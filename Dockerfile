FROM openjdk:8-jdk

MAINTAINER Amjad Khader <amjadkhader49@gmail.com>

COPY /target/skeleton-service-b-1.0.0.jar skeleton-service-b.jar

EXPOSE 8094

ENTRYPOINT ["java", "-jar", "skeleton-service-b.jar"]