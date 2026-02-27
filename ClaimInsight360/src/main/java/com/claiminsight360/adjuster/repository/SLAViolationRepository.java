package com.claiminsight360.adjuster.repository;

import com.claiminsight360.adjuster.entity.SLAViolation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SLAViolationRepository extends JpaRepository<SLAViolation, Long> {
    List<SLAViolation> findByClaimID(String claimID);
}
