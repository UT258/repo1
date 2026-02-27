package com.claiminsight360.fraud.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "risk_score")
public class RiskScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scoreID;

    private String claimID;

    private Double scoreValue;

    private LocalDate computedDate;

    public RiskScore() {}

    public RiskScore(String claimID, Double scoreValue, LocalDate computedDate) {
        this.claimID = claimID;
        this.scoreValue = scoreValue;
        this.computedDate = computedDate;
    }

    public Long getScoreID() { return scoreID; }
    public void setScoreID(Long scoreID) { this.scoreID = scoreID; }
    public String getClaimID() { return claimID; }
    public void setClaimID(String claimID) { this.claimID = claimID; }
    public Double getScoreValue() { return scoreValue; }
    public void setScoreValue(Double scoreValue) { this.scoreValue = scoreValue; }
    public LocalDate getComputedDate() { return computedDate; }
    public void setComputedDate(LocalDate computedDate) { this.computedDate = computedDate; }
}
