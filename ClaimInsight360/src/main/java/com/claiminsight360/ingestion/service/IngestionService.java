package com.claiminsight360.ingestion.service;

import com.claiminsight360.ingestion.entity.ClaimRaw;
import com.claiminsight360.ingestion.entity.DataFeed;
import com.claiminsight360.common.exception.ResourceNotFoundException;
import com.claiminsight360.ingestion.repository.ClaimRawRepository;
import com.claiminsight360.ingestion.repository.DataFeedRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IngestionService {

    private final DataFeedRepository dataFeedRepository;
    private final ClaimRawRepository claimRawRepository;

    public IngestionService(DataFeedRepository dataFeedRepository, ClaimRawRepository claimRawRepository) {
        this.dataFeedRepository = dataFeedRepository;
        this.claimRawRepository = claimRawRepository;
    }

    public DataFeed createDataFeed(DataFeed feed) {
        return dataFeedRepository.save(feed);
    }

    public List<DataFeed> getAllDataFeeds() {
        return dataFeedRepository.findAll();
    }

    public Optional<DataFeed> getDataFeedById(Long id) {
        return dataFeedRepository.findById(id);
    }

    public DataFeed updateDataFeed(Long id, DataFeed updated) {
        return dataFeedRepository.findById(id).map(f -> {
            f.setFeedType(updated.getFeedType());
            f.setSourceSystem(updated.getSourceSystem());
            f.setLastSyncDate(updated.getLastSyncDate());
            f.setStatus(updated.getStatus());
            return dataFeedRepository.save(f);
        }).orElseThrow(() -> new ResourceNotFoundException("DataFeed", id));
    }

    public void deleteDataFeed(Long id) {
        dataFeedRepository.deleteById(id);
    }

    public ClaimRaw ingestClaim(ClaimRaw claimRaw) {
        return claimRawRepository.save(claimRaw);
    }

    public List<ClaimRaw> getAllClaimRaws() {
        return claimRawRepository.findAll();
    }

    public List<ClaimRaw> getClaimRawsByClaimId(String claimID) {
        return claimRawRepository.findByClaimID(claimID);
    }
}
