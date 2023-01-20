#!/bin/bash
set -e

DOCKER_BRIDGE=`ip -4 -o addr | grep docker | awk '{split($4, a, "/"); print a[1]}'`
docker run -d --name planning-poker-rest -m 32m \
       -p 8080:8080 \
       --add-host "host.docker.internal:$DOCKER_BRIDGE" \
       planning-poker-rest:latest \
       ./planning-poker-rest \
       -Dquarkus.http.host=localhost \
       -Dquarkus.datasource.jdbc.url=jdbc:postgresql://host.docker.internal:5432/postgres
