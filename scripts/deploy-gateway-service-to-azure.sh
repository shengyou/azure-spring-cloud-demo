#!/bin/zsh

source environment.sh

# 部署 Gateway Service Spring Cloud App
az spring-cloud app deploy \
    -g "$AZ_RESOURCE_GROUP" \
    -s "$AZ_SPRING_CLOUD_NAME" \
    -n  "$GATEWAY_INSTANCE" \
    --runtime-version Java_11 \
    --artifact-path ../gateway-service/build/libs/gateway-service-0.0.1-SNAPSHOT.jar
