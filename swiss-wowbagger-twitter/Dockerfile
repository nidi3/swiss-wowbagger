FROM ghcr.io/graalvm/graalvm-ce:java17-21.3 AS build
RUN gu install native-image

WORKDIR /build
COPY target/swiss-wowbagger-twitter-*.jar ./wowbagger.jar
RUN native-image -cp ./wowbagger.jar -H:Name=swiss-wowbagger-twitter

FROM europe-west6-docker.pkg.dev/swiss-wowbagger/docker/mbrola
COPY --from=build /build/swiss-wowbagger-twitter /usr/local/bin/swiss-wowbagger-twitter
EXPOSE 8080
ENTRYPOINT /usr/local/bin/swiss-wowbagger-twitter