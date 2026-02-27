package com.claiminsight360.denial.service;

import com.claiminsight360.denial.entity.DenialPattern;
import com.claiminsight360.denial.entity.LeakageFlag;
import com.claiminsight360.denial.repository.DenialPatternRepository;
import com.claiminsight360.denial.repository.LeakageFlagRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DenialService {

    private final DenialPatternRepository denialPatternRepository;
    private final LeakageFlagRepository leakageFlagRepository;

    public DenialService(DenialPatternRepository denialPatternRepository, LeakageFlagRepository leakageFlagRepository) {
        this.denialPatternRepository = denialPatternRepository;
        this.leakageFlagRepository = leakageFlagRepository;
    }

    public DenialPattern createDenialPattern(DenialPattern pattern) {
        return denialPatternRepository.save(pattern);
    }

    public List<DenialPattern> getAllDenialPatterns() {
        return denialPatternRepository.findAll();
    }

    public Optional<DenialPattern> getDenialPatternById(Long id) {
        return denialPatternRepository.findById(id);
    }

    public List<DenialPattern> getDenialPatternsByClaimId(String claimID) {
        return denialPatternRepository.findByClaimID(claimID);
    }

    public List<DenialPattern> getDenialPatternsByCode(String denialCode) {
        return denialPatternRepository.findByDenialCode(denialCode);
    }

    public void deleteDenialPattern(Long id) {
        denialPatternRepository.deleteById(id);
    }

    public LeakageFlag createLeakageFlag(LeakageFlag flag) {
        return leakageFlagRepository.save(flag);
    }

    public List<LeakageFlag> getAllLeakageFlags() {
        return leakageFlagRepository.findAll();
    }

    public Optional<LeakageFlag> getLeakageFlagById(Long id) {
        return leakageFlagRepository.findById(id);
    }

    public List<LeakageFlag> getLeakageFlagsByClaimId(String claimID) {
        return leakageFlagRepository.findByClaimID(claimID);
    }

    public void deleteLeakageFlag(Long id) {
        leakageFlagRepository.deleteById(id);
    }
}
