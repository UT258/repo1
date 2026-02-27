package com.claiminsight360.fraud.repository;

import com.claiminsight360.fraud.entity.RiskScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RiskScoreRepository extends JpaRepository<RiskScore, Long> {
    List<RiskScore> findByClaimID(String claimID);
}
