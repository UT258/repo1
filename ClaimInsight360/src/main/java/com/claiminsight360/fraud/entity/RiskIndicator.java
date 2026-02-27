package com.claiminsight360.fraud.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "risk_indicator")
public class RiskIndicator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long indicatorID;

    private String claimID;

    @Enumerated(EnumType.STRING)
    private IndicatorType indicatorType;

    private String severity;

    private LocalDate triggeredDate;

    public enum IndicatorType {
        HIGH_COST, UNUSUAL_TIMING, PATTERN
    }

    public RiskIndicator() {}

    public RiskIndicator(String claimID, IndicatorType indicatorType, String severity, LocalDate triggeredDate) {
        this.claimID = claimID;
        this.indicatorType = indicatorType;
        this.severity = severity;
        this.triggeredDate = triggeredDate;
    }

    public Long getIndicatorID() { return indicatorID; }
    public void setIndicatorID(Long indicatorID) { this.indicatorID = indicatorID; }
    public String getClaimID() { return claimID; }
    public void setClaimID(String claimID) { this.claimID = claimID; }
    public IndicatorType getIndicatorType() { return indicatorType; }
    public void setIndicatorType(IndicatorType indicatorType) { this.indicatorType = indicatorType; }
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
    public LocalDate getTriggeredDate() { return triggeredDate; }
    public void setTriggeredDate(LocalDate triggeredDate) { this.triggeredDate = triggeredDate; }
}
