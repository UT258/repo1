package com.claiminsight360.adjuster.service;

import com.claiminsight360.adjuster.entity.AdjusterPerformance;
import com.claiminsight360.adjuster.entity.SLAViolation;
import com.claiminsight360.adjuster.repository.AdjusterPerformanceRepository;
import com.claiminsight360.adjuster.repository.SLAViolationRepository;
import com.claiminsight360.common.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdjusterService {

    private final AdjusterPerformanceRepository adjusterPerformanceRepository;
    private final SLAViolationRepository slaViolationRepository;

    public AdjusterService(AdjusterPerformanceRepository adjusterPerformanceRepository,
                           SLAViolationRepository slaViolationRepository) {
        this.adjusterPerformanceRepository = adjusterPerformanceRepository;
        this.slaViolationRepository = slaViolationRepository;
    }

    public AdjusterPerformance createPerformance(AdjusterPerformance perf) {
        return adjusterPerformanceRepository.save(perf);
    }

    public List<AdjusterPerformance> getAllPerformances() {
        return adjusterPerformanceRepository.findAll();
    }

    public Optional<AdjusterPerformance> getPerformanceById(Long id) {
        return adjusterPerformanceRepository.findById(id);
    }

    public List<AdjusterPerformance> getPerformanceByAdjusterId(String adjusterID) {
        return adjusterPerformanceRepository.findByAdjusterID(adjusterID);
    }

    public AdjusterPerformance updatePerformance(Long id, AdjusterPerformance updated) {
        return adjusterPerformanceRepository.findById(id).map(p -> {
            p.setAdjusterID(updated.getAdjusterID());
            p.setClaimsHandled(updated.getClaimsHandled());
            p.setAvgTAT(updated.getAvgTAT());
            p.setQualityScore(updated.getQualityScore());
            p.setPeriod(updated.getPeriod());
            return adjusterPerformanceRepository.save(p);
        }).orElseThrow(() -> new ResourceNotFoundException("AdjusterPerformance", id));
    }

    public void deletePerformance(Long id) {
        adjusterPerformanceRepository.deleteById(id);
    }

    public SLAViolation createSLAViolation(SLAViolation violation) {
        return slaViolationRepository.save(violation);
    }

    public List<SLAViolation> getAllSLAViolations() {
        return slaViolationRepository.findAll();
    }

    public Optional<SLAViolation> getSLAViolationById(Long id) {
        return slaViolationRepository.findById(id);
    }

    public List<SLAViolation> getSLAViolationsByClaimId(String claimID) {
        return slaViolationRepository.findByClaimID(claimID);
    }

    public void deleteSLAViolation(Long id) {
        slaViolationRepository.deleteById(id);
    }
}
