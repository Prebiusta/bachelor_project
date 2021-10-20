@echo off

set FORWARD=kubectl port-forward

%FORWARD% svc/bpm-service-svc 8000:8000