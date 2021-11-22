#!/bin/bash

FORWARD="kubectl port-forward"

$FORWARD svc/mysql 3306:3306 \
  & $FORWARD svc/idp-keycloak 8080:8080