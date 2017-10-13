FROM tomcat:9-jre8
MAINTAINER hb

ADD myuan-test /home/app/

EXPOSE 8080
CMD ["catalina.sh", "run"]