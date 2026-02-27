package com.claiminsight360.ingestion.controller;

import com.claiminsight360.ingestion.entity.ClaimRaw;
import com.claiminsight360.ingestion.entity.DataFeed;
import com.claiminsight360.ingestion.service.IngestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ingestion")
public class IngestionController {

    private final IngestionService ingestionService;

    public IngestionController(IngestionService ingestionService) {
        this.ingestionService = ingestionService;
    }

    @PostMapping("/feeds")
    public ResponseEntity<DataFeed> createDataFeed(@RequestBody DataFeed feed) {
        return ResponseEntity.ok(ingestionService.createDataFeed(feed));
    }

    @GetMapping("/feeds")
    public ResponseEntity<List<DataFeed>> getAllDataFeeds() {
        return ResponseEntity.ok(ingestionService.getAllDataFeeds());
    }

    @GetMapping("/feeds/{id}")
    public ResponseEntity<DataFeed> getDataFeedById(@PathVariable Long id) {
        return ingestionService.getDataFeedById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/feeds/{id}")
    public ResponseEntity<DataFeed> updateDataFeed(@PathVariable Long id, @RequestBody DataFeed feed) {
        return ResponseEntity.ok(ingestionService.updateDataFeed(id, feed));
    }

    @DeleteMapping("/feeds/{id}")
    public ResponseEntity<Void> deleteDataFeed(@PathVariable Long id) {
        ingestionService.deleteDataFeed(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/claims/raw")
    public ResponseEntity<ClaimRaw> ingestClaim(@RequestBody ClaimRaw claimRaw) {
        return ResponseEntity.ok(ingestionService.ingestClaim(claimRaw));
    }

    @GetMapping("/claims/raw")
    public ResponseEntity<List<ClaimRaw>> getAllClaimRaws() {
        return ResponseEntity.ok(ingestionService.getAllClaimRaws());
    }

    @GetMapping("/claims/raw/{claimID}")
    public ResponseEntity<List<ClaimRaw>> getClaimRawsByClaimId(@PathVariable String claimID) {
        return ResponseEntity.ok(ingestionService.getClaimRawsByClaimId(claimID));
    }
}
