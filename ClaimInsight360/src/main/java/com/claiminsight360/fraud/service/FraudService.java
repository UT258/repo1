package com.claiminsight360.fraud.service;

import com.claiminsight360.fraud.entity.RiskIndicator;
import com.claiminsight360.fraud.entity.RiskScore;
import com.claiminsight360.fraud.repository.RiskIndicatorRepository;
import com.claiminsight360.fraud.repository.RiskScoreRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FraudService {

    private final RiskIndicatorRepository riskIndicatorRepository;
    private final RiskScoreRepository riskScoreRepository;

    public FraudService(RiskIndicatorRepository riskIndicatorRepository, RiskScoreRepository riskScoreRepository) {
        this.riskIndicatorRepository = riskIndicatorRepository;
        this.riskScoreRepository = riskScoreRepository;
    }

    public RiskIndicator createRiskIndicator(RiskIndicator indicator) {
        return riskIndicatorRepository.save(indicator);
    }

    public List<RiskIndicator> getAllRiskIndicators() {
        return riskIndicatorRepository.findAll();
    }

    public Optional<RiskIndicator> getRiskIndicatorById(Long id) {
        return riskIndicatorRepository.findById(id);
    }

    public List<RiskIndicator> getRiskIndicatorsByClaimId(String claimID) {
        return riskIndicatorRepository.findByClaimID(claimID);
    }

    public void deleteRiskIndicator(Long id) {
        riskIndicatorRepository.deleteById(id);
    }

    public RiskScore createRiskScore(RiskScore score) {
        return riskScoreRepository.save(score);
    }

    public List<RiskScore> getAllRiskScores() {
        return riskScoreRepository.findAll();
    }

    public Optional<RiskScore> getRiskScoreById(Long id) {
        return riskScoreRepository.findById(id);
    }

    public List<RiskScore> getRiskScoresByClaimId(String claimID) {
        return riskScoreRepository.findByClaimID(claimID);
    }

    public void deleteRiskScore(Long id) {
        riskScoreRepository.deleteById(id);
    }
}
