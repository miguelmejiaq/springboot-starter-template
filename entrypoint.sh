#!/bin/bash

set -a
exec java -jar -Dspring.profiles.active=$SPRING_PROFILE "/app/app.jar"
set +a%