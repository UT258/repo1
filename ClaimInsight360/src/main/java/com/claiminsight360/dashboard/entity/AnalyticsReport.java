package com.claiminsight360.dashboard.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "analytics_report")
public class AnalyticsReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportID;

    private String scope;

    @Column(length = 5000)
    private String metrics;

    private LocalDate generatedDate;

    public AnalyticsReport() {}

    public AnalyticsReport(String scope, String metrics, LocalDate generatedDate) {
        this.scope = scope;
        this.metrics = metrics;
        this.generatedDate = generatedDate;
    }

    public Long getReportID() { return reportID; }
    public void setReportID(Long reportID) { this.reportID = reportID; }
    public String getScope() { return scope; }
    public void setScope(String scope) { this.scope = scope; }
    public String getMetrics() { return metrics; }
    public void setMetrics(String metrics) { this.metrics = metrics; }
    public LocalDate getGeneratedDate() { return generatedDate; }
    public void setGeneratedDate(LocalDate generatedDate) { this.generatedDate = generatedDate; }
}
