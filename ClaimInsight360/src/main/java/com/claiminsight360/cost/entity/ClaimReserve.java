package com.claiminsight360.cost.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "claim_reserve")
public class ClaimReserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reserveID;

    private String claimID;

    private BigDecimal reserveAmount;

    private LocalDate updatedDate;

    public ClaimReserve() {}

    public ClaimReserve(String claimID, BigDecimal reserveAmount, LocalDate updatedDate) {
        this.claimID = claimID;
        this.reserveAmount = reserveAmount;
        this.updatedDate = updatedDate;
    }

    public Long getReserveID() { return reserveID; }
    public void setReserveID(Long reserveID) { this.reserveID = reserveID; }
    public String getClaimID() { return claimID; }
    public void setClaimID(String claimID) { this.claimID = claimID; }
    public BigDecimal getReserveAmount() { return reserveAmount; }
    public void setReserveAmount(BigDecimal reserveAmount) { this.reserveAmount = reserveAmount; }
    public LocalDate getUpdatedDate() { return updatedDate; }
    public void setUpdatedDate(LocalDate updatedDate) { this.updatedDate = updatedDate; }
}
