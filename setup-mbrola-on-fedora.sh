docker create --name mbrola-copy-source europe-west6-docker.pkg.dev/swiss-wowbagger/docker/mbrola && \
docker cp mbrola-copy-source:/usr/bin/mbrola ~/bin/mbrola && \
docker rm mbrola-copy-source