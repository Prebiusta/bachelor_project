#!/bin/bash
eval $(minikube docker-env)

# Forcing images to be reloaded
kubectl delete --all deployments
kubectl delete --all svc
kubectl delete --all configmaps

DOCKER_BUILDKIT=1 docker-compose --project-name signfluent build --parallel

KUBECTL="kubectl apply -f"

$KUBECTL 01_config
$KUBECTL 02_pv
$KUBECTL 03_pvc
$KUBECTL 04_svc
$KUBECTL 05_deployment
