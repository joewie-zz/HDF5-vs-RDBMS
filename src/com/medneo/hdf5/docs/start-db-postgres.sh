#!/bin/bash

#
# docker based startup ... to check/extend the schema the fast way
#
docker run -d -v ${PWD}/postgresinit/load-test-db-postgres.sql:/docker-entrypoint-initdb.d/createDb.sql:ro -p 5432:5432 postgres:10.5-alpine

