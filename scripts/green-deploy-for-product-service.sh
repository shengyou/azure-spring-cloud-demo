#!/bin/zsh

source environment.sh

# 藍綠部署 - 上 Staging
az spring-cloud app deployment create \
    --name green \
    -g "$AZ_RESOURCE_GROUP" \
    -s "$AZ_SPRING_CLOUD_NAME" \
    --app "$PRODUCT_INSTANCE" \
    --runtime-version Java_11 \
    --artifact-path ../product-service/build/libs/product-service-0.0.1-SNAPSHOT.jar
