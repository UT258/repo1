package com.claiminsight360.fraud.repository;

import com.claiminsight360.fraud.entity.RiskIndicator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RiskIndicatorRepository extends JpaRepository<RiskIndicator, Long> {
    List<RiskIndicator> findByClaimID(String claimID);
}
