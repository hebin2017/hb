FROM myapp:latest
MAINTAINER hb

ADD myuan-test /home/app/

EXPOSE 8080
CMD ["catalina.sh", "run"]