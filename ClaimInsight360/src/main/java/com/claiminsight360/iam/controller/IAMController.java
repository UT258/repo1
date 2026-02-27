package com.claiminsight360.iam.controller;

import com.claiminsight360.iam.entity.AuditLog;
import com.claiminsight360.iam.entity.User;
import com.claiminsight360.iam.service.IAMService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/iam")
public class IAMController {

    private final IAMService iamService;

    public IAMController(IAMService iamService) {
        this.iamService = iamService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(iamService.createUser(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(iamService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return iamService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(iamService.updateUser(id, user));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        iamService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/audit-logs")
    public ResponseEntity<AuditLog> createAuditLog(@RequestBody AuditLog log) {
        return ResponseEntity.ok(iamService.createAuditLog(log));
    }

    @GetMapping("/audit-logs")
    public ResponseEntity<List<AuditLog>> getAllAuditLogs() {
        return ResponseEntity.ok(iamService.getAllAuditLogs());
    }

    @GetMapping("/audit-logs/user/{userID}")
    public ResponseEntity<List<AuditLog>> getAuditLogsByUser(@PathVariable Long userID) {
        return ResponseEntity.ok(iamService.getAuditLogsByUser(userID));
    }
}
