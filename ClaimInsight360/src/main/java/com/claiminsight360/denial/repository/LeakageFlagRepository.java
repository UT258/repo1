package com.claiminsight360.denial.repository;

import com.claiminsight360.denial.entity.LeakageFlag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LeakageFlagRepository extends JpaRepository<LeakageFlag, Long> {
    List<LeakageFlag> findByClaimID(String claimID);
}
