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
echo "Pushing messages"
node publish-messages/index.js $1


