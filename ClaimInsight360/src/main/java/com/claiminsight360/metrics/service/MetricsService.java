package com.claiminsight360.metrics.service;

import com.claiminsight360.metrics.entity.ClaimKPI;
import com.claiminsight360.common.exception.ResourceNotFoundException;
import com.claiminsight360.metrics.repository.ClaimKPIRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MetricsService {

    private final ClaimKPIRepository claimKPIRepository;

    public MetricsService(ClaimKPIRepository claimKPIRepository) {
        this.claimKPIRepository = claimKPIRepository;
    }

    public ClaimKPI createKPI(ClaimKPI kpi) {
        return claimKPIRepository.save(kpi);
    }

    public List<ClaimKPI> getAllKPIs() {
        return claimKPIRepository.findAll();
    }

    public Optional<ClaimKPI> getKPIById(Long id) {
        return claimKPIRepository.findById(id);
    }

    public List<ClaimKPI> getKPIsByClaimId(String claimID) {
        return claimKPIRepository.findByClaimID(claimID);
    }

    public List<ClaimKPI> getKPIsByMetricName(String metricName) {
        return claimKPIRepository.findByMetricName(metricName);
    }

    public ClaimKPI updateKPI(Long id, ClaimKPI updated) {
        return claimKPIRepository.findById(id).map(k -> {
            k.setClaimID(updated.getClaimID());
            k.setMetricName(updated.getMetricName());
            k.setMetricValue(updated.getMetricValue());
            k.setMetricDate(updated.getMetricDate());
            return claimKPIRepository.save(k);
        }).orElseThrow(() -> new ResourceNotFoundException("ClaimKPI", id));
    }

    public void deleteKPI(Long id) {
        claimKPIRepository.deleteById(id);
    }
}
