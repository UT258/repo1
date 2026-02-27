package com.claiminsight360.ingestion.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "claim_raw")
public class ClaimRaw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rawID;

    private String claimID;

    @Column(length = 10000)
    private String payloadJSON;

    private LocalDateTime ingestedDate;

    public ClaimRaw() {}

    public ClaimRaw(String claimID, String payloadJSON, LocalDateTime ingestedDate) {
        this.claimID = claimID;
        this.payloadJSON = payloadJSON;
        this.ingestedDate = ingestedDate;
    }

    public Long getRawID() { return rawID; }
    public void setRawID(Long rawID) { this.rawID = rawID; }
    public String getClaimID() { return claimID; }
    public void setClaimID(String claimID) { this.claimID = claimID; }
    public String getPayloadJSON() { return payloadJSON; }
    public void setPayloadJSON(String payloadJSON) { this.payloadJSON = payloadJSON; }
    public LocalDateTime getIngestedDate() { return ingestedDate; }
    public void setIngestedDate(LocalDateTime ingestedDate) { this.ingestedDate = ingestedDate; }
}
