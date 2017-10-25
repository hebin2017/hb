FROM myapp:latest
MAINTAINER hb

ADD boot.jar /home/app/

EXPOSE 8080
CMD ["java","-jar","/home/app/boot.jar"]