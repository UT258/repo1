package com.claiminsight360.dashboard.controller;

import com.claiminsight360.dashboard.entity.AnalyticsReport;
import com.claiminsight360.dashboard.service.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @PostMapping("/reports")
    public ResponseEntity<AnalyticsReport> createReport(@RequestBody AnalyticsReport report) {
        return ResponseEntity.ok(dashboardService.createReport(report));
    }

    @GetMapping("/reports")
    public ResponseEntity<List<AnalyticsReport>> getAllReports() {
        return ResponseEntity.ok(dashboardService.getAllReports());
    }

    @GetMapping("/reports/{id}")
    public ResponseEntity<AnalyticsReport> getReportById(@PathVariable Long id) {
        return dashboardService.getReportById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/reports/scope/{scope}")
    public ResponseEntity<List<AnalyticsReport>> getReportsByScope(@PathVariable String scope) {
        return ResponseEntity.ok(dashboardService.getReportsByScope(scope));
    }

    @PutMapping("/reports/{id}")
    public ResponseEntity<AnalyticsReport> updateReport(@PathVariable Long id, @RequestBody AnalyticsReport report) {
        return ResponseEntity.ok(dashboardService.updateReport(id, report));
    }

    @DeleteMapping("/reports/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        dashboardService.deleteReport(id);
        return ResponseEntity.noContent().build();
    }
}
