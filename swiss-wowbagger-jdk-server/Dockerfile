FROM bitnami/minideb:bullseye
RUN echo 'deb http://deb.debian.org/debian bullseye contrib' >> /etc/apt/sources.list
RUN apt-get update && apt-get -y install mbrola
ADD target/jlink /run
EXPOSE 7125
CMD /run/bin/wowbagger
