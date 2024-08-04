package com.prometheus.grafana.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/prometheus-grafana")
public class PrometheusGrafanaController {

    private static final Logger log = LoggerFactory.getLogger(PrometheusGrafanaController.class);

    @GetMapping
    public ResponseEntity<String> get() {
        log.info("GET REQUEST");
        return ResponseEntity.ok("GET DONE");
    }

    @PostMapping
    public ResponseEntity<String> create() {
        log.info("POST REQUEST");
        return ResponseEntity.ok("POST DONE");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id) {
        log.debug("UPDATE REQUEST : {}", id);
        return ResponseEntity.ok("PUT DONE : " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        log.debug("DELETE REQUEST : {}", id);
        return ResponseEntity.ok("DELETE DONE : " + id);
    }
}
