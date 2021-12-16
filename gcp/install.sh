#!/bin/bash
KUBECTL="kubectl apply -f"

$KUBECTL 00_cert
$KUBECTL 01_config
$KUBECTL 02_pv
$KUBECTL 03_pvc
$KUBECTL 04_svc
$KUBECTL 05_ingress
$KUBECTL 06_deployment
