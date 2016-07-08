#!/bin/sh
cd $(dirname $0)

cd complete

./mvnw clean package spring-boot:run

exit
