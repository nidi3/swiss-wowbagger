FROM openjdk:13
RUN yum -y install glibc.i686
COPY target/swiss-wowbagger-twitter-0.0.2-SNAPSHOT-fat.jar /tmp/bot.jar
CMD java -jar /tmp/bot.jar
