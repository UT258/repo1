package com.claiminsight360.cost.repository;

import com.claiminsight360.cost.entity.AgingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AgingRecordRepository extends JpaRepository<AgingRecord, Long> {
    List<AgingRecord> findByClaimID(String claimID);
    List<AgingRecord> findByAgingBucket(AgingRecord.AgingBucket agingBucket);
}
