package com.claiminsight360.cost.repository;

import com.claiminsight360.cost.entity.ClaimCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClaimCostRepository extends JpaRepository<ClaimCost, Long> {
    List<ClaimCost> findByClaimID(String claimID);
}
