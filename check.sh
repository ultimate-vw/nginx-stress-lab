#!/usr/bin/env bash

set -e

echo "Checking Java backend..."
curl -s -u "${ADMIN_USER}:${ADMIN_PASS}" "http://localhost:${BACKEND_PORT}/api/ping" | grep -q pong && echo "Backend OK"

echo "Checking Locust UI..."
curl -s "http://localhost:8089" >/dev/null && echo "Locust OK"

echo "Checking Elasticsearch..."
curl -s "http://localhost:9200/_cluster/health" | grep -qE '"status":"(green|yellow)"' && echo "Elasticsearch OK"

echo "Checking Kibana..."
curl -s "http://localhost:5601" >/dev/null && echo "Kibana OK"

echo "Checking Prometheus..."
curl -s "http://localhost:9090/-/ready" >/dev/null && echo "Prometheus OK"

echo "Checking Grafana..."
curl -s "http://localhost:3000" >/dev/null && echo "Grafana OK"

echo "All services are up."