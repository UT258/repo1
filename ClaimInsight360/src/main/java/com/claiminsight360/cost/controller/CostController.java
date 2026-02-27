package com.claiminsight360.cost.controller;

import com.claiminsight360.cost.entity.AgingRecord;
import com.claiminsight360.cost.entity.ClaimCost;
import com.claiminsight360.cost.entity.ClaimReserve;
import com.claiminsight360.cost.service.CostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cost")
public class CostController {

    private final CostService costService;

    public CostController(CostService costService) {
        this.costService = costService;
    }

    @PostMapping("/costs")
    public ResponseEntity<ClaimCost> createClaimCost(@RequestBody ClaimCost cost) {
        return ResponseEntity.ok(costService.createClaimCost(cost));
    }

    @GetMapping("/costs")
    public ResponseEntity<List<ClaimCost>> getAllClaimCosts() {
        return ResponseEntity.ok(costService.getAllClaimCosts());
    }

    @GetMapping("/costs/{id}")
    public ResponseEntity<ClaimCost> getClaimCostById(@PathVariable Long id) {
        return costService.getClaimCostById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/costs/claim/{claimID}")
    public ResponseEntity<List<ClaimCost>> getClaimCostsByClaimId(@PathVariable String claimID) {
        return ResponseEntity.ok(costService.getClaimCostsByClaimId(claimID));
    }

    @DeleteMapping("/costs/{id}")
    public ResponseEntity<Void> deleteClaimCost(@PathVariable Long id) {
        costService.deleteClaimCost(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/reserves")
    public ResponseEntity<ClaimReserve> createClaimReserve(@RequestBody ClaimReserve reserve) {
        return ResponseEntity.ok(costService.createClaimReserve(reserve));
    }

    @GetMapping("/reserves")
    public ResponseEntity<List<ClaimReserve>> getAllClaimReserves() {
        return ResponseEntity.ok(costService.getAllClaimReserves());
    }

    @GetMapping("/reserves/{id}")
    public ResponseEntity<ClaimReserve> getClaimReserveById(@PathVariable Long id) {
        return costService.getClaimReserveById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/reserves/claim/{claimID}")
    public ResponseEntity<List<ClaimReserve>> getClaimReservesByClaimId(@PathVariable String claimID) {
        return ResponseEntity.ok(costService.getClaimReservesByClaimId(claimID));
    }

    @DeleteMapping("/reserves/{id}")
    public ResponseEntity<Void> deleteClaimReserve(@PathVariable Long id) {
        costService.deleteClaimReserve(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/aging")
    public ResponseEntity<AgingRecord> createAgingRecord(@RequestBody AgingRecord record) {
        return ResponseEntity.ok(costService.createAgingRecord(record));
    }

    @GetMapping("/aging")
    public ResponseEntity<List<AgingRecord>> getAllAgingRecords() {
        return ResponseEntity.ok(costService.getAllAgingRecords());
    }

    @GetMapping("/aging/{id}")
    public ResponseEntity<AgingRecord> getAgingRecordById(@PathVariable Long id) {
        return costService.getAgingRecordById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/aging/claim/{claimID}")
    public ResponseEntity<List<AgingRecord>> getAgingRecordsByClaimId(@PathVariable String claimID) {
        return ResponseEntity.ok(costService.getAgingRecordsByClaimId(claimID));
    }

    @GetMapping("/aging/bucket/{bucket}")
    public ResponseEntity<List<AgingRecord>> getAgingRecordsByBucket(@PathVariable AgingRecord.AgingBucket bucket) {
        return ResponseEntity.ok(costService.getAgingRecordsByBucket(bucket));
    }

    @DeleteMapping("/aging/{id}")
    public ResponseEntity<Void> deleteAgingRecord(@PathVariable Long id) {
        costService.deleteAgingRecord(id);
        return ResponseEntity.noContent().build();
    }
}
