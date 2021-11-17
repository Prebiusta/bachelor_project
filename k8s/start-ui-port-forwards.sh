#!/bin/bash

FORWARD="kubectl port-forward"

$FORWARD svc/business-service-svc 8006:8006 --address='0.0.0.0' /
  $FORWARD svc/idp-keycloak 8080:8080