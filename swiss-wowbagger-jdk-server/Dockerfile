FROM ghcr.io/graalvm/graalvm-ce:java17-21.3 AS build
RUN gu install native-image

WORKDIR /build
COPY target/swiss-wowbagger-jdk-server-*.jar ./wowbagger.jar
RUN native-image -cp ./wowbagger.jar -H:Name=swiss-wowbagger-jdk-server

FROM europe-west6-docker.pkg.dev/swiss-wowbagger/docker/mbrola
COPY --from=build /build/swiss-wowbagger-jdk-server /usr/local/bin/swiss-wowbagger-jdk-server
EXPOSE 7125
ENTRYPOINT /usr/local/bin/swiss-wowbagger-jdk-server
