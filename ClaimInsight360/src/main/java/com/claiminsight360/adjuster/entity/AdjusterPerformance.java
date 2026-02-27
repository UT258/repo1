package com.claiminsight360.adjuster.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "adjuster_performance")
public class AdjusterPerformance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long perfID;

    private String adjusterID;

    private Integer claimsHandled;

    private Double avgTAT;

    private Double qualityScore;

    private String period;

    public AdjusterPerformance() {}

    public AdjusterPerformance(String adjusterID, Integer claimsHandled, Double avgTAT, Double qualityScore, String period) {
        this.adjusterID = adjusterID;
        this.claimsHandled = claimsHandled;
        this.avgTAT = avgTAT;
        this.qualityScore = qualityScore;
        this.period = period;
    }

    public Long getPerfID() { return perfID; }
    public void setPerfID(Long perfID) { this.perfID = perfID; }
    public String getAdjusterID() { return adjusterID; }
    public void setAdjusterID(String adjusterID) { this.adjusterID = adjusterID; }
    public Integer getClaimsHandled() { return claimsHandled; }
    public void setClaimsHandled(Integer claimsHandled) { this.claimsHandled = claimsHandled; }
    public Double getAvgTAT() { return avgTAT; }
    public void setAvgTAT(Double avgTAT) { this.avgTAT = avgTAT; }
    public Double getQualityScore() { return qualityScore; }
    public void setQualityScore(Double qualityScore) { this.qualityScore = qualityScore; }
    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }
}
