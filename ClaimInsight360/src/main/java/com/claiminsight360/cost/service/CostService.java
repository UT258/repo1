package com.claiminsight360.cost.service;

import com.claiminsight360.cost.entity.AgingRecord;
import com.claiminsight360.cost.entity.ClaimCost;
import com.claiminsight360.cost.entity.ClaimReserve;
import com.claiminsight360.cost.repository.AgingRecordRepository;
import com.claiminsight360.cost.repository.ClaimCostRepository;
import com.claiminsight360.cost.repository.ClaimReserveRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CostService {

    private final ClaimCostRepository claimCostRepository;
    private final ClaimReserveRepository claimReserveRepository;
    private final AgingRecordRepository agingRecordRepository;

    public CostService(ClaimCostRepository claimCostRepository,
                       ClaimReserveRepository claimReserveRepository,
                       AgingRecordRepository agingRecordRepository) {
        this.claimCostRepository = claimCostRepository;
        this.claimReserveRepository = claimReserveRepository;
        this.agingRecordRepository = agingRecordRepository;
    }

    public ClaimCost createClaimCost(ClaimCost cost) {
        return claimCostRepository.save(cost);
    }

    public List<ClaimCost> getAllClaimCosts() {
        return claimCostRepository.findAll();
    }

    public Optional<ClaimCost> getClaimCostById(Long id) {
        return claimCostRepository.findById(id);
    }

    public List<ClaimCost> getClaimCostsByClaimId(String claimID) {
        return claimCostRepository.findByClaimID(claimID);
    }

    public void deleteClaimCost(Long id) {
        claimCostRepository.deleteById(id);
    }

    public ClaimReserve createClaimReserve(ClaimReserve reserve) {
        return claimReserveRepository.save(reserve);
    }

    public List<ClaimReserve> getAllClaimReserves() {
        return claimReserveRepository.findAll();
    }

    public Optional<ClaimReserve> getClaimReserveById(Long id) {
        return claimReserveRepository.findById(id);
    }

    public List<ClaimReserve> getClaimReservesByClaimId(String claimID) {
        return claimReserveRepository.findByClaimID(claimID);
    }

    public void deleteClaimReserve(Long id) {
        claimReserveRepository.deleteById(id);
    }

    public AgingRecord createAgingRecord(AgingRecord record) {
        return agingRecordRepository.save(record);
    }

    public List<AgingRecord> getAllAgingRecords() {
        return agingRecordRepository.findAll();
    }

    public Optional<AgingRecord> getAgingRecordById(Long id) {
        return agingRecordRepository.findById(id);
    }

    public List<AgingRecord> getAgingRecordsByClaimId(String claimID) {
        return agingRecordRepository.findByClaimID(claimID);
    }

    public List<AgingRecord> getAgingRecordsByBucket(AgingRecord.AgingBucket bucket) {
        return agingRecordRepository.findByAgingBucket(bucket);
    }

    public void deleteAgingRecord(Long id) {
        agingRecordRepository.deleteById(id);
    }
}
