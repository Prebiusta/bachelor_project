@echo off
kubectl delete --all deployments
kubectl delete --all services
kubectl delete --all pods

docker-compose --project-name signfluent build --parallel --force-rm

set KUBECTL=kubectl apply -f

%KUBECTL% 00_ca_config.yml
%KUBECTL% 00_database_secret.yml
%KUBECTL% 00_firebase_sa_account_credentials_secret.yml
%KUBECTL% 00_keycloak_secret.yml

%KUBECTL% 00_keycloak.yml

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