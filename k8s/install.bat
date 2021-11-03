@echo off
kubectl delete --all deployments
kubectl delete --all services
kubectl delete --all pods

set DOCKER_RMI=docker rmi

%DOCKER_RMI% signfluent/document-service:latest
%DOCKER_RMI% signfluent/notification-service:latest
%DOCKER_RMI% signfluent/user-service:latest
%DOCKER_RMI% signfluent/certificate-authority:latest
%DOCKER_RMI% signfluent/bpm-service:latest

docker-compose --project-name signfluent build

set KUBECTL=kubectl apply -f

%KUBECTL% 00_keycloak.yml
%KUBECTL% 00_firebase_sa_account_credentials_secret.yml

%KUBECTL% 01_bpm_service_svc.yml
%KUBECTL% 01_ca_svc.yml
%KUBECTL% 01_device_service_svc.yml
%KUBECTL% 01_document_service_svc.yml
%KUBECTL% 01_notification_service_svc.yml
%KUBECTL% 01_user_service_svc.yml

%KUBECTL% 02_bpm_service_deployment.yml
%KUBECTL% 02_ca_deployment.yml
%KUBECTL% 02_device_service_deployment.yml
%KUBECTL% 02_document_service_deployment.yml
%KUBECTL% 02_notification_service_deployment.yml
%KUBECTL% 02_user_service_deployment.yml