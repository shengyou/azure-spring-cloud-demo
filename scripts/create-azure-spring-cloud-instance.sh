#!/bin/zsh

source environment.sh

# 建立 Azure Spring Cloud
az spring-cloud create \
    -g "$AZ_RESOURCE_GROUP" \
    -n "$AZ_SPRING_CLOUD_NAME" \
    --sku standard
