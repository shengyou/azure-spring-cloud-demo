#!/bin/zsh

source environment.sh

# 刪除舊的部署
az spring-cloud app deployment delete \
    --name green \
    -g "$AZ_RESOURCE_GROUP" \
    -s "$AZ_SPRING_CLOUD_NAME" \
    --app  "$PRODUCT_INSTANCE"
