package com.claiminsight360.ingestion.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "data_feed")
public class DataFeed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedID;

    @Enumerated(EnumType.STRING)
    private FeedType feedType;

    private String sourceSystem;

    private LocalDate lastSyncDate;

    private String status;

    public enum FeedType {
        CLAIM, POLICY, PAYMENT, RESERVE
    }

    public DataFeed() {}

    public DataFeed(FeedType feedType, String sourceSystem, LocalDate lastSyncDate, String status) {
        this.feedType = feedType;
        this.sourceSystem = sourceSystem;
        this.lastSyncDate = lastSyncDate;
        this.status = status;
    }

    public Long getFeedID() { return feedID; }
    public void setFeedID(Long feedID) { this.feedID = feedID; }
    public FeedType getFeedType() { return feedType; }
    public void setFeedType(FeedType feedType) { this.feedType = feedType; }
    public String getSourceSystem() { return sourceSystem; }
    public void setSourceSystem(String sourceSystem) { this.sourceSystem = sourceSystem; }
    public LocalDate getLastSyncDate() { return lastSyncDate; }
    public void setLastSyncDate(LocalDate lastSyncDate) { this.lastSyncDate = lastSyncDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
