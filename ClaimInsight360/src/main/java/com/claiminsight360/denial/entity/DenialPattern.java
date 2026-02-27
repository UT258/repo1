package com.claiminsight360.denial.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "denial_pattern")
public class DenialPattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patternID;

    private String claimID;

    private String denialCode;

    private String reason;

    private LocalDate occurrenceDate;

    public DenialPattern() {}

    public DenialPattern(String claimID, String denialCode, String reason, LocalDate occurrenceDate) {
        this.claimID = claimID;
        this.denialCode = denialCode;
        this.reason = reason;
        this.occurrenceDate = occurrenceDate;
    }

    public Long getPatternID() { return patternID; }
    public void setPatternID(Long patternID) { this.patternID = patternID; }
    public String getClaimID() { return claimID; }
    public void setClaimID(String claimID) { this.claimID = claimID; }
    public String getDenialCode() { return denialCode; }
    public void setDenialCode(String denialCode) { this.denialCode = denialCode; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public LocalDate getOccurrenceDate() { return occurrenceDate; }
    public void setOccurrenceDate(LocalDate occurrenceDate) { this.occurrenceDate = occurrenceDate; }
}
