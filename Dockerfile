FROM gradle:8.13.0-jdk23-corretto AS build

WORKDIR /app

COPY build.gradle settings.gradle ./
COPY src ./src

RUN gradle build -x test

RUN VERSION=$(gradle properties --no-daemon --console=plain -q | grep "^version:" | awk '{printf $2}') \
    && mv build/libs/docker-lab-${VERSION}.jar build/libs/docker-lab-app.jar

FROM amazoncorretto:23-alpine-jdk

WORKDIR /app

COPY --from=build /app/build/libs/docker-lab-app.jar app.jar

COPY entrypoint.sh .

RUN chmod +x /app/entrypoint.sh

EXPOSE 8080

ENTRYPOINT [ "/bin/sh", "-c", "source /app/entrypoint.sh" ]
