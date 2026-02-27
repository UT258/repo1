package com.claiminsight360.ingestion.repository;

import com.claiminsight360.ingestion.entity.DataFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DataFeedRepository extends JpaRepository<DataFeed, Long> {
    List<DataFeed> findByStatus(String status);
}
