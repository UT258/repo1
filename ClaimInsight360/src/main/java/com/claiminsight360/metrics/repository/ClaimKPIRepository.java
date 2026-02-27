package com.claiminsight360.metrics.repository;

import com.claiminsight360.metrics.entity.ClaimKPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClaimKPIRepository extends JpaRepository<ClaimKPI, Long> {
    List<ClaimKPI> findByClaimID(String claimID);
    List<ClaimKPI> findByMetricName(String metricName);
}
