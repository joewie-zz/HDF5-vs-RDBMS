#!/bin/sh

docker run -d --rm --name mysql -e 'MYSQL_ROOT_PASSWORD=pwd' -e 'MYSQL_DATABASE=loadtestdb' -v ${PWD}/mysqlinit:/docker-entrypoint-initdb.d:ro mysql:8.0.12

