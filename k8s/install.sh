#!/bin/bash
eval $(minikube docker-env)
docker-compose --project-name signfluent build

KUBECTL="kubectl apply -f"

$KUBECTL 01_bpm_service_svc.yml
$KUBECTL 01_ca_svc.yml
$KUBECTL 01_document_service_svc.yml
$KUBECTL 01_notification_service_svc.yml
$KUBECTL 01_user_service_svc.yml

$KUBECTL 02_bpm_service_deployment.yml
$KUBECTL 02_ca_deployment.yml
$KUBECTL 02_document_service_deployment.yml
$KUBECTL 02_notification_service_deployment.yml
$KUBECTL 02_user_service_deployment.yml

# Forcing images to be reloaded
kubectl delete --all pods