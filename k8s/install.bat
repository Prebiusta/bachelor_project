@echo off
kubectl delete --all deployments
kubectl delete --all services
kubectl delete --all pods

docker-compose --project-name signfluent build --parallel --force-rm

set KUBECTL=kubectl apply -f

%KUBECTL% 01_config
%KUBECTL% 02_pv
%KUBECTL% 03_pvc
%KUBECTL% 04_svc
%KUBECTL% 05_deployment