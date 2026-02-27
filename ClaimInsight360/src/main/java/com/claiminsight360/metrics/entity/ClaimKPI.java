package com.claiminsight360.metrics.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "claim_kpi")
public class ClaimKPI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kpiID;

    private String claimID;

    private String metricName;

    private Double metricValue;

    private LocalDate metricDate;

    public ClaimKPI() {}

    public ClaimKPI(String claimID, String metricName, Double metricValue, LocalDate metricDate) {
        this.claimID = claimID;
        this.metricName = metricName;
        this.metricValue = metricValue;
        this.metricDate = metricDate;
    }

    public Long getKpiID() { return kpiID; }
    public void setKpiID(Long kpiID) { this.kpiID = kpiID; }
    public String getClaimID() { return claimID; }
    public void setClaimID(String claimID) { this.claimID = claimID; }
    public String getMetricName() { return metricName; }
    public void setMetricName(String metricName) { this.metricName = metricName; }
    public Double getMetricValue() { return metricValue; }
    public void setMetricValue(Double metricValue) { this.metricValue = metricValue; }
    public LocalDate getMetricDate() { return metricDate; }
    public void setMetricDate(LocalDate metricDate) { this.metricDate = metricDate; }
}
