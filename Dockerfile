FROM myapp:latest
MAINTAINER hebin

ADD boot.jar /home/app/

EXPOSE 8080
CMD ["java","-jar","/home/app/boot.jar"]