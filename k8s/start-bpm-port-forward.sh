#!/bin/bash

FORWARD="kubectl port-forward"

$FORWARD svc/document-service-svc 8001:8001 \
  & $FORWARD svc/user-service-svc 8003:8003 \
  & $FORWARD svc/device-service-svc 8005:8005 \
  & $FORWARD svc/notification-service-svc 8002:8002 \
  & $FORWARD svc/ca-svc 8004:8004 \
  & $FORWARD svc/idp-keycloak 8080:8080 \
  & $FORWARD svc/mysql 3306:3306