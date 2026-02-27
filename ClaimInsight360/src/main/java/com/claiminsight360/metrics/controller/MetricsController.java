package com.claiminsight360.metrics.controller;

import com.claiminsight360.metrics.entity.ClaimKPI;
import com.claiminsight360.metrics.service.MetricsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/metrics")
public class MetricsController {

    private final MetricsService metricsService;

    public MetricsController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @PostMapping("/kpis")
    public ResponseEntity<ClaimKPI> createKPI(@RequestBody ClaimKPI kpi) {
        return ResponseEntity.ok(metricsService.createKPI(kpi));
    }

    @GetMapping("/kpis")
    public ResponseEntity<List<ClaimKPI>> getAllKPIs() {
        return ResponseEntity.ok(metricsService.getAllKPIs());
    }

    @GetMapping("/kpis/{id}")
    public ResponseEntity<ClaimKPI> getKPIById(@PathVariable Long id) {
        return metricsService.getKPIById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/kpis/claim/{claimID}")
    public ResponseEntity<List<ClaimKPI>> getKPIsByClaimId(@PathVariable String claimID) {
        return ResponseEntity.ok(metricsService.getKPIsByClaimId(claimID));
    }

    @GetMapping("/kpis/metric/{metricName}")
    public ResponseEntity<List<ClaimKPI>> getKPIsByMetricName(@PathVariable String metricName) {
        return ResponseEntity.ok(metricsService.getKPIsByMetricName(metricName));
    }

    @PutMapping("/kpis/{id}")
    public ResponseEntity<ClaimKPI> updateKPI(@PathVariable Long id, @RequestBody ClaimKPI kpi) {
        return ResponseEntity.ok(metricsService.updateKPI(id, kpi));
    }

    @DeleteMapping("/kpis/{id}")
    public ResponseEntity<Void> deleteKPI(@PathVariable Long id) {
        metricsService.deleteKPI(id);
        return ResponseEntity.noContent().build();
    }
}
