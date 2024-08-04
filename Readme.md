# Spring Boot Monitoring with Prometheus and Grafana

This repository contains the configuration and setup instructions for monitoring a Spring Boot application using Prometheus and Grafana. The application is built using Maven and listens on port 8082.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Setting Up Prometheus](#setting-up-prometheus)
- [Setting Up Grafana](#setting-up-grafana)
- [Exposing Metrics in Spring Boot](#exposing-metrics-in-spring-boot)
- [Importing the Grafana Dashboard](#importing-the-grafana-dashboard)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

- Java Development Kit (JDK) 8 or later
- Maven for building the Spring Boot application
- Docker (optional, for containerized deployment)

## Setting Up Prometheus

1. **Download Prometheus**:
    - Visit the [Prometheus download page](https://prometheus.io/download/) and download the latest release.

2. **Configure Prometheus**:
    - Edit the `prometheus.yml` file to include a job for your Spring Boot application:
      ```yaml
      scrape_configs:
        - job_name: 'spring-boot'
          metrics_path: '/actuator/prometheus'
          static_configs:
            - targets: ['localhost:8082']
      ```

3. **Start Prometheus**:
    - Run the following command to start Prometheus:
      ```sh
      ./prometheus --config.file=prometheus.yml
      ```

## Setting Up Grafana

1. **Download Grafana**:
    - Visit the [Grafana download page](https://grafana.com/grafana/download) and download the latest release.

2. **Start Grafana**:
    - Run the following command to start Grafana:
      ```sh
      ./bin/grafana-server
      ```

3. **Access Grafana**:
    - Open your browser and go to `http://localhost:3000`.
    - Log in with the default credentials (username: `admin`, password: `admin`).

## Exposing Metrics in Spring Boot

1. **Add Dependencies**:
    - Add the `micrometer-registry-prometheus` dependency to your `pom.xml`:
      ```xml
      <dependency>
          <groupId>io.micrometer</groupId>
          <artifactId>micrometer-registry-prometheus</artifactId>
      </dependency>
      ```

2. **Enable Actuator Endpoints**:
    - Ensure that the Prometheus endpoint is enabled in your `application.properties` or `application.yml`:
      ```properties
      management.endpoints.web.exposure.include=health,info,prometheus
      server.port=8082
      ```

## Importing the Grafana Dashboard

1. **Import the Dashboard**:
    - In Grafana, go to the "Create" menu and select "Import".
    - Copy and paste the JSON configuration from the `grafana-dashboard.json` file in this repository.
    - Replace `${DS_PROMETHEUS}` with the actual name of your Prometheus data source.

2. **Save and Explore**:
    - Save the dashboard and start exploring your Spring Boot application metrics.