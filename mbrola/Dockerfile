# Minimal base image with mbrola and nl2 voice installed
FROM debian:stable-slim
RUN echo 'deb https://deb.debian.org/debian stable non-free contrib' >> /etc/apt/sources.list
RUN apt-get update && apt-get -y install mbrola mbrola-nl2 && rm -rf /var/lib/apt/lists/*