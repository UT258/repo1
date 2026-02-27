package com.claiminsight360.cost.repository;

import com.claiminsight360.cost.entity.ClaimReserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClaimReserveRepository extends JpaRepository<ClaimReserve, Long> {
    List<ClaimReserve> findByClaimID(String claimID);
}
