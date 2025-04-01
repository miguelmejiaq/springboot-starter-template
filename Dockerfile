FROM gradle:8.13.0-jdk23-corretto AS build

WORKDIR /app

COPY build.gradle settings.gradle ./
COPY src ./src

RUN gradle build -x test

FROM amazoncorretto:23-alpine-jdk

WORKDIR /app

ARG API_VERSION=""

COPY --from=build /app/build/libs/docker-lab-${API_VERSION}.jar app.jar

COPY entrypoint.sh .

RUN chmod +x /app/entrypoint.sh

EXPOSE 8080

ENTRYPOINT [ "/bin/sh", "-c", "source /app/entrypoint.sh" ]
