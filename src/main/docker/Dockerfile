####
# This Dockerfile is used in order to build a container that runs the Quarkus application in native (no JVM) mode.
# It uses a micro base image, tuned for Quarkus native executables.
# It reduces the size of the resulting container image.
# Check https://quarkus.io/guides/quarkus-runtime-base-image for further information about this image.
#
# Before building the container image run:
#
# ./mvnw package -Pnative
#
# Then, build the image with:
#
# docker build -f src/main/docker/Dockerfile -t quarkus/planning-poker-rest .
#
# Then run the container using:
#
# docker run -i --rm -p 8080:8080 quarkus/planning-poker-rest
#
###

FROM quay.io/quarkus/quarkus-micro-image:1.0
WORKDIR /app/
RUN chown 1001 /app \
    && chmod "g+rwX" /app \
    && chown 1001:root /app
COPY --chown=1001:root target/*-runner /app/planning-poker-rest

EXPOSE 8080
USER 1001

CMD ["./planning-poker-rest", "-Dquarkus.http.host=localhost"]
