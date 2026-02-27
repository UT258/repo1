package com.claiminsight360.denial.controller;

import com.claiminsight360.denial.entity.DenialPattern;
import com.claiminsight360.denial.entity.LeakageFlag;
import com.claiminsight360.denial.service.DenialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/denial")
public class DenialController {

    private final DenialService denialService;

    public DenialController(DenialService denialService) {
        this.denialService = denialService;
    }

    @PostMapping("/patterns")
    public ResponseEntity<DenialPattern> createDenialPattern(@RequestBody DenialPattern pattern) {
        return ResponseEntity.ok(denialService.createDenialPattern(pattern));
    }

    @GetMapping("/patterns")
    public ResponseEntity<List<DenialPattern>> getAllDenialPatterns() {
        return ResponseEntity.ok(denialService.getAllDenialPatterns());
    }

    @GetMapping("/patterns/{id}")
    public ResponseEntity<DenialPattern> getDenialPatternById(@PathVariable Long id) {
        return denialService.getDenialPatternById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/patterns/claim/{claimID}")
    public ResponseEntity<List<DenialPattern>> getDenialPatternsByClaimId(@PathVariable String claimID) {
        return ResponseEntity.ok(denialService.getDenialPatternsByClaimId(claimID));
    }

    @GetMapping("/patterns/code/{denialCode}")
    public ResponseEntity<List<DenialPattern>> getDenialPatternsByCode(@PathVariable String denialCode) {
        return ResponseEntity.ok(denialService.getDenialPatternsByCode(denialCode));
    }

    @DeleteMapping("/patterns/{id}")
    public ResponseEntity<Void> deleteDenialPattern(@PathVariable Long id) {
        denialService.deleteDenialPattern(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/leakages")
    public ResponseEntity<LeakageFlag> createLeakageFlag(@RequestBody LeakageFlag flag) {
        return ResponseEntity.ok(denialService.createLeakageFlag(flag));
    }

    @GetMapping("/leakages")
    public ResponseEntity<List<LeakageFlag>> getAllLeakageFlags() {
        return ResponseEntity.ok(denialService.getAllLeakageFlags());
    }

    @GetMapping("/leakages/{id}")
    public ResponseEntity<LeakageFlag> getLeakageFlagById(@PathVariable Long id) {
        return denialService.getLeakageFlagById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/leakages/claim/{claimID}")
    public ResponseEntity<List<LeakageFlag>> getLeakageFlagsByClaimId(@PathVariable String claimID) {
        return ResponseEntity.ok(denialService.getLeakageFlagsByClaimId(claimID));
    }

    @DeleteMapping("/leakages/{id}")
    public ResponseEntity<Void> deleteLeakageFlag(@PathVariable Long id) {
        denialService.deleteLeakageFlag(id);
        return ResponseEntity.noContent().build();
    }
}
