#!/bin/zsh

source environment.sh

# 建立 Gateway Service Spring Cloud App
az spring-cloud app create \
    -g "$AZ_RESOURCE_GROUP" \
    -s "$AZ_SPRING_CLOUD_NAME" \
    -n "$GATEWAY_INSTANCE" \
    --runtime-version Java_11 \
    --is-public true
