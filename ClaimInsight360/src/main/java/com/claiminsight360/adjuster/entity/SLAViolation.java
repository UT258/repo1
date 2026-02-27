package com.claiminsight360.adjuster.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sla_violation")
public class SLAViolation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long violationID;

    private String claimID;

    private String violationType;

    private LocalDate violationDate;

    public SLAViolation() {}

    public SLAViolation(String claimID, String violationType, LocalDate violationDate) {
        this.claimID = claimID;
        this.violationType = violationType;
        this.violationDate = violationDate;
    }

    public Long getViolationID() { return violationID; }
    public void setViolationID(Long violationID) { this.violationID = violationID; }
    public String getClaimID() { return claimID; }
    public void setClaimID(String claimID) { this.claimID = claimID; }
    public String getViolationType() { return violationType; }
    public void setViolationType(String violationType) { this.violationType = violationType; }
    public LocalDate getViolationDate() { return violationDate; }
    public void setViolationDate(LocalDate violationDate) { this.violationDate = violationDate; }
}
