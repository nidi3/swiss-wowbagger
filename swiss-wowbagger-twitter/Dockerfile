FROM adoptopenjdk/openjdk11-openj9:debianslim-jre
RUN echo 'deb http://deb.debian.org/debian buster contrib' >> /etc/apt/sources.list
RUN apt-get update && apt-get -y install mbrola
COPY target/swiss-wowbagger-twitter-0.0.2-SNAPSHOT-fat.jar /tmp/bot.jar
CMD java -jar /tmp/bot.jar
