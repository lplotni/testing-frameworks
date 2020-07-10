#!/bin/sh
set -eo pipefail
export status="not_active"
GREEN='\033[1;32m'
NC='\033[0m' # No Color
function check {
  echo "${GREEN}Checking...${NC}"
  sleep 3
  docker-compose logs queue | grep 'startup complete' \
      && status="active" \
      || status="not_active"
}
echo "${GREEN}Booting up everything...${NC}"
docker-compose up -d 
while [ $status == "not_active" ]; do check ; done
echo "${GREEN}Pushing messages${NC}"
node publish-messages/index.js $1


