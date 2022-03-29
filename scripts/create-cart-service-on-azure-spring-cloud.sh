#!/bin/zsh

source environment.sh

# 建立 Cart Service Spring Cloud App
az spring-cloud app create \
    -g "$AZ_RESOURCE_GROUP" \
    -s "$AZ_SPRING_CLOUD_NAME" \
    -n "$CART_INSTANCE" \
     --assign-endpoint true \
    --runtime-version Java_11
