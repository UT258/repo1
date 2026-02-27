package com.claiminsight360.ingestion.repository;

import com.claiminsight360.ingestion.entity.ClaimRaw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClaimRawRepository extends JpaRepository<ClaimRaw, Long> {
    List<ClaimRaw> findByClaimID(String claimID);
}
