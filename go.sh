#!/bin/sh
set -eo pipefail
if [ $(docker ps | grep 'rabbit') -n ]
then
    echo "Starting rabbitmq..."
    container_name=$(docker run -d --hostname my-rabbit -p 8081:15672 -p 5672:5672 rabbitmq:3-management)
    echo "Checking container: $container_name"
    while [ "$(docker inspect -f '{{.State.Running}}' ${container_name} 2>/dev/null)" = "false" ]; do sleep 1s; done
fi
echo "Rabbitmq runnig"
if [ $(docker ps | grep 'postgres') -n ]
then
    echo "Starting postgres..."
    container_name=$(docker run -p 5432:5432 -e POSTGRES_PASSWORD=test -e POSTGRES_DB=bookings-db -d postgres)
    echo "Checking container: $container_name"
    while [ "$(docker inspect -f '{{.State.Running}}' ${container_name} 2>/dev/null)" = "false" ]; do sleep 1s; done
fi
echo "Postgres running"
echo "Pushing messages"
node publish-messages/index.js $1


