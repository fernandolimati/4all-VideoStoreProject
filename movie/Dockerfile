FROM openjdk:14-jdk-alpine

MAINTAINER Fernando Lima <flimaeng@gmail.com>

RUN apk update
RUN apk upgrade

WORKDIR /var/www/java

ARG JAR_FILE

COPY ${JAR_FILE} user-service.jar

ENV TZ=""
ENV PORT=""
ENV SWAGGER_HOST=""
ENV MYSQL_IP=""
ENV MYSQL_PORT=""
ENV MYSQL_DB=""
ENV MYSQL_USER=""
ENV MYSQL_PASSWORD=""

RUN echo $TZ > /etc/timezone

EXPOSE $PORT

ENTRYPOINT java -jar user-service.jar ${TZ} ${PORT} ${SWAGGER_HOST} ${MYSQL_IP} ${MYSQL_PORT} ${MYSQL_DB} ${MYSQL_USER} ${MYSQL_PASSWORD}