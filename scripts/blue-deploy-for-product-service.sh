#!/bin/zsh

source environment.sh

# 藍綠部署 - 上 Production
az spring-cloud app set-deployment \
    -g "$AZ_RESOURCE_GROUP" \
    -s "$AZ_SPRING_CLOUD_NAME" \
    -n  "$PRODUCT_INSTANCE" \
    --deployment green
