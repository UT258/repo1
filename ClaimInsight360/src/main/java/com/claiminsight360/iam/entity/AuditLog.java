package com.claiminsight360.iam.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_log")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditID;

    private Long userID;

    private String action;

    private String resource;

    private LocalDateTime timestamp;

    @Column(length = 2000)
    private String metadata;

    public AuditLog() {}

    public AuditLog(Long userID, String action, String resource, LocalDateTime timestamp, String metadata) {
        this.userID = userID;
        this.action = action;
        this.resource = resource;
        this.timestamp = timestamp;
        this.metadata = metadata;
    }

    public Long getAuditID() { return auditID; }
    public void setAuditID(Long auditID) { this.auditID = auditID; }
    public Long getUserID() { return userID; }
    public void setUserID(Long userID) { this.userID = userID; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public String getResource() { return resource; }
    public void setResource(String resource) { this.resource = resource; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public String getMetadata() { return metadata; }
    public void setMetadata(String metadata) { this.metadata = metadata; }
}
