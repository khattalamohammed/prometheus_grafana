#!/bin/bash

# Build the Docker image
docker build -t prometheus-grafana-image .

# Run docker-compose
docker-compose up