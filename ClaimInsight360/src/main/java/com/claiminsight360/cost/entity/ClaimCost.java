package com.claiminsight360.cost.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "claim_cost")
public class ClaimCost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long costID;

    private String claimID;

    @Enumerated(EnumType.STRING)
    private CostType costType;

    private BigDecimal amount;

    private LocalDate costDate;

    public enum CostType {
        MEDICAL, LEGAL, REPAIR, SETTLEMENT
    }

    public ClaimCost() {}

    public ClaimCost(String claimID, CostType costType, BigDecimal amount, LocalDate costDate) {
        this.claimID = claimID;
        this.costType = costType;
        this.amount = amount;
        this.costDate = costDate;
    }

    public Long getCostID() { return costID; }
    public void setCostID(Long costID) { this.costID = costID; }
    public String getClaimID() { return claimID; }
    public void setClaimID(String claimID) { this.claimID = claimID; }
    public CostType getCostType() { return costType; }
    public void setCostType(CostType costType) { this.costType = costType; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public LocalDate getCostDate() { return costDate; }
    public void setCostDate(LocalDate costDate) { this.costDate = costDate; }
}
