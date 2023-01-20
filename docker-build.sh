#!/bin/bash
set -e

./mvnw package -Pnative
docker build -f src/main/docker/Dockerfile -t planning-poker-rest:latest .
