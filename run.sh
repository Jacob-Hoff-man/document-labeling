#!/usr/bin/env bash
# build new jar file in labeling dir
cd labeling
./mvnw clean package
# clean up docker
cd ..
docker compose down --volumes
docker rmi document-labeling-be-spring
docker compose build --no-cache
docker compose up -d --remove-orphans