@echo off

set FORWARD=kubectl port-forward

%FORWARD% svc/document-service-svc 8001:8001 & %FORWARD% svc/user-service-svc 8003:8003 & %FORWARD% svc/notification-service-svc 8002:8002 & %FORWARD% svc/ca-svc 8004:8004