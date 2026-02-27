package com.claiminsight360.denial.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "leakage_flag")
public class LeakageFlag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leakageID;

    private String claimID;

    @Enumerated(EnumType.STRING)
    private LeakageType leakageType;

    private BigDecimal estimatedLoss;

    private LocalDate identifiedDate;

    public enum LeakageType {
        OVERPAYMENT, DELAY, ERROR
    }

    public LeakageFlag() {}

    public LeakageFlag(String claimID, LeakageType leakageType, BigDecimal estimatedLoss, LocalDate identifiedDate) {
        this.claimID = claimID;
        this.leakageType = leakageType;
        this.estimatedLoss = estimatedLoss;
        this.identifiedDate = identifiedDate;
    }

    public Long getLeakageID() { return leakageID; }
    public void setLeakageID(Long leakageID) { this.leakageID = leakageID; }
    public String getClaimID() { return claimID; }
    public void setClaimID(String claimID) { this.claimID = claimID; }
    public LeakageType getLeakageType() { return leakageType; }
    public void setLeakageType(LeakageType leakageType) { this.leakageType = leakageType; }
    public BigDecimal getEstimatedLoss() { return estimatedLoss; }
    public void setEstimatedLoss(BigDecimal estimatedLoss) { this.estimatedLoss = estimatedLoss; }
    public LocalDate getIdentifiedDate() { return identifiedDate; }
    public void setIdentifiedDate(LocalDate identifiedDate) { this.identifiedDate = identifiedDate; }
}
