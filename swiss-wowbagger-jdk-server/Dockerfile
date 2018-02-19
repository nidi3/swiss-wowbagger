FROM bitnami/minideb
RUN echo 'deb http://ftp.de.debian.org/debian jessie main non-free' >> /etc/apt/sources.list
RUN apt-get update && apt-get -y install mbrola
ADD target/jlink /run
EXPOSE 7125
CMD /run/bin/wowbagger