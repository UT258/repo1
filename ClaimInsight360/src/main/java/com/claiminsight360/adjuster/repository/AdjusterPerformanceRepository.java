package com.claiminsight360.adjuster.repository;

import com.claiminsight360.adjuster.entity.AdjusterPerformance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AdjusterPerformanceRepository extends JpaRepository<AdjusterPerformance, Long> {
    List<AdjusterPerformance> findByAdjusterID(String adjusterID);
}
