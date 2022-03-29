#!/bin/zsh

source environment.sh

# 部署 Product Service Spring Cloud App
az spring-cloud app deploy \
    -g "$AZ_RESOURCE_GROUP" \
    -s "$AZ_SPRING_CLOUD_NAME" \
    -n  "$PRODUCT_INSTANCE" \
    --runtime-version Java_11 \
    --artifact-path ../product-service/build/libs/product-service-0.0.1-SNAPSHOT.jar
