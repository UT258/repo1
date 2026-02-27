package com.claiminsight360.denial.repository;

import com.claiminsight360.denial.entity.DenialPattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DenialPatternRepository extends JpaRepository<DenialPattern, Long> {
    List<DenialPattern> findByClaimID(String claimID);
    List<DenialPattern> findByDenialCode(String denialCode);
}
