#!/bin/zsh

source environment.sh

# 看 Cart Service Log
az spring-cloud app logs \
     -g "$AZ_RESOURCE_GROUP" \
     -s "$AZ_SPRING_CLOUD_NAME" \
     -n  "$CART_INSTANCE" \
     -f
