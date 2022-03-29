#!/bin/zsh

source environment.sh

# 部署 Cart Service Spring Cloud App
az spring-cloud app deploy \
    -g "$AZ_RESOURCE_GROUP" \
    -s "$AZ_SPRING_CLOUD_NAME" \
    -n  "$CART_INSTANCE" \
    --runtime-version Java_11 \
    --artifact-path ../cart-service/build/libs/cart-service-0.0.1-SNAPSHOT.jar
