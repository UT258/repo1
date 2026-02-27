package com.claiminsight360.cost.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "aging_record")
public class AgingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agingID;

    private String claimID;

    private Integer agingDays;

    @Enumerated(EnumType.STRING)
    private AgingBucket agingBucket;

    public enum AgingBucket {
        DAYS_0_30, DAYS_31_60, DAYS_61_90, DAYS_90_PLUS
    }

    public AgingRecord() {}

    public AgingRecord(String claimID, Integer agingDays, AgingBucket agingBucket) {
        this.claimID = claimID;
        this.agingDays = agingDays;
        this.agingBucket = agingBucket;
    }

    public Long getAgingID() { return agingID; }
    public void setAgingID(Long agingID) { this.agingID = agingID; }
    public String getClaimID() { return claimID; }
    public void setClaimID(String claimID) { this.claimID = claimID; }
    public Integer getAgingDays() { return agingDays; }
    public void setAgingDays(Integer agingDays) { this.agingDays = agingDays; }
    public AgingBucket getAgingBucket() { return agingBucket; }
    public void setAgingBucket(AgingBucket agingBucket) { this.agingBucket = agingBucket; }
}
