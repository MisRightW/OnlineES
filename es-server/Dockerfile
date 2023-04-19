FROM docker.aiaudit.com.cn/jdk/openjdk:8-jdk-alpine
LABEL MAINTAINER=fengling

EXPOSE 8379

ENV APP_HOME /home/app/es

RUN mkdir -p $APP_HOME/uploads
RUN mkdir -p $APP_HOME/config
RUN mkdir -p $APP_HOME/logs

VOLUME /tmp
VOLUME $APP_HOME/config
VOLUME $APP_HOME/uploads

COPY target/exam-api.jar $APP_HOME/app.jar
COPY docker-entrypoint.sh /usr/local/bin/docker-entrypoint.sh

RUN chmod 755 -c /usr/local/bin/docker-entrypoint.sh

WORKDIR $APP_HOME

ENTRYPOINT [ "/usr/local/bin/docker-entrypoint.sh" ]


# docker build -t docker.aiaudit.com.cn/exam/exam-api:v1.0.0.002 .
# docker push docker.aiaudit.com.cn/exam/exam-api:v1.0.0.002