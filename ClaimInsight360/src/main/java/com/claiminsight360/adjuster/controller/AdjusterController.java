package com.claiminsight360.adjuster.controller;

import com.claiminsight360.adjuster.entity.AdjusterPerformance;
import com.claiminsight360.adjuster.entity.SLAViolation;
import com.claiminsight360.adjuster.service.AdjusterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/adjuster")
public class AdjusterController {

    private final AdjusterService adjusterService;

    public AdjusterController(AdjusterService adjusterService) {
        this.adjusterService = adjusterService;
    }

    @PostMapping("/performance")
    public ResponseEntity<AdjusterPerformance> createPerformance(@RequestBody AdjusterPerformance perf) {
        return ResponseEntity.ok(adjusterService.createPerformance(perf));
    }

    @GetMapping("/performance")
    public ResponseEntity<List<AdjusterPerformance>> getAllPerformances() {
        return ResponseEntity.ok(adjusterService.getAllPerformances());
    }

    @GetMapping("/performance/{id}")
    public ResponseEntity<AdjusterPerformance> getPerformanceById(@PathVariable Long id) {
        return adjusterService.getPerformanceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/performance/adjuster/{adjusterID}")
    public ResponseEntity<List<AdjusterPerformance>> getPerformanceByAdjusterId(@PathVariable String adjusterID) {
        return ResponseEntity.ok(adjusterService.getPerformanceByAdjusterId(adjusterID));
    }

    @PutMapping("/performance/{id}")
    public ResponseEntity<AdjusterPerformance> updatePerformance(@PathVariable Long id, @RequestBody AdjusterPerformance perf) {
        return ResponseEntity.ok(adjusterService.updatePerformance(id, perf));
    }

    @DeleteMapping("/performance/{id}")
    public ResponseEntity<Void> deletePerformance(@PathVariable Long id) {
        adjusterService.deletePerformance(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/sla-violations")
    public ResponseEntity<SLAViolation> createSLAViolation(@RequestBody SLAViolation violation) {
        return ResponseEntity.ok(adjusterService.createSLAViolation(violation));
    }

    @GetMapping("/sla-violations")
    public ResponseEntity<List<SLAViolation>> getAllSLAViolations() {
        return ResponseEntity.ok(adjusterService.getAllSLAViolations());
    }

    @GetMapping("/sla-violations/{id}")
    public ResponseEntity<SLAViolation> getSLAViolationById(@PathVariable Long id) {
        return adjusterService.getSLAViolationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/sla-violations/claim/{claimID}")
    public ResponseEntity<List<SLAViolation>> getSLAViolationsByClaimId(@PathVariable String claimID) {
        return ResponseEntity.ok(adjusterService.getSLAViolationsByClaimId(claimID));
    }

    @DeleteMapping("/sla-violations/{id}")
    public ResponseEntity<Void> deleteSLAViolation(@PathVariable Long id) {
        adjusterService.deleteSLAViolation(id);
        return ResponseEntity.noContent().build();
    }
}
