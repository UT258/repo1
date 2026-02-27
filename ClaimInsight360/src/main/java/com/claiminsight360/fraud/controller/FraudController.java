package com.claiminsight360.fraud.controller;

import com.claiminsight360.fraud.entity.RiskIndicator;
import com.claiminsight360.fraud.entity.RiskScore;
import com.claiminsight360.fraud.service.FraudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fraud")
public class FraudController {

    private final FraudService fraudService;

    public FraudController(FraudService fraudService) {
        this.fraudService = fraudService;
    }

    @PostMapping("/indicators")
    public ResponseEntity<RiskIndicator> createRiskIndicator(@RequestBody RiskIndicator indicator) {
        return ResponseEntity.ok(fraudService.createRiskIndicator(indicator));
    }

    @GetMapping("/indicators")
    public ResponseEntity<List<RiskIndicator>> getAllRiskIndicators() {
        return ResponseEntity.ok(fraudService.getAllRiskIndicators());
    }

    @GetMapping("/indicators/{id}")
    public ResponseEntity<RiskIndicator> getRiskIndicatorById(@PathVariable Long id) {
        return fraudService.getRiskIndicatorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/indicators/claim/{claimID}")
    public ResponseEntity<List<RiskIndicator>> getRiskIndicatorsByClaimId(@PathVariable String claimID) {
        return ResponseEntity.ok(fraudService.getRiskIndicatorsByClaimId(claimID));
    }

    @DeleteMapping("/indicators/{id}")
    public ResponseEntity<Void> deleteRiskIndicator(@PathVariable Long id) {
        fraudService.deleteRiskIndicator(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/scores")
    public ResponseEntity<RiskScore> createRiskScore(@RequestBody RiskScore score) {
        return ResponseEntity.ok(fraudService.createRiskScore(score));
    }

    @GetMapping("/scores")
    public ResponseEntity<List<RiskScore>> getAllRiskScores() {
        return ResponseEntity.ok(fraudService.getAllRiskScores());
    }

    @GetMapping("/scores/{id}")
    public ResponseEntity<RiskScore> getRiskScoreById(@PathVariable Long id) {
        return fraudService.getRiskScoreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/scores/claim/{claimID}")
    public ResponseEntity<List<RiskScore>> getRiskScoresByClaimId(@PathVariable String claimID) {
        return ResponseEntity.ok(fraudService.getRiskScoresByClaimId(claimID));
    }

    @DeleteMapping("/scores/{id}")
    public ResponseEntity<Void> deleteRiskScore(@PathVariable Long id) {
        fraudService.deleteRiskScore(id);
        return ResponseEntity.noContent().build();
    }
}
