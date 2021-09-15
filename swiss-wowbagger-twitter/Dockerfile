FROM adoptopenjdk/openjdk11-openj9:debianslim-jre
RUN echo 'deb http://deb.debian.org/debian buster contrib' >> /etc/apt/sources.list
COPY target/swiss-wowbagger-twitter-0.0.2-SNAPSHOT-fat.jar /tmp/bot.jar
CMD java -jar /tmp/bot.jar
