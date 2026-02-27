package com.claiminsight360.dashboard.service;

import com.claiminsight360.dashboard.entity.AnalyticsReport;
import com.claiminsight360.common.exception.ResourceNotFoundException;
import com.claiminsight360.dashboard.repository.AnalyticsReportRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DashboardService {

    private final AnalyticsReportRepository analyticsReportRepository;

    public DashboardService(AnalyticsReportRepository analyticsReportRepository) {
        this.analyticsReportRepository = analyticsReportRepository;
    }

    public AnalyticsReport createReport(AnalyticsReport report) {
        return analyticsReportRepository.save(report);
    }

    public List<AnalyticsReport> getAllReports() {
        return analyticsReportRepository.findAll();
    }

    public Optional<AnalyticsReport> getReportById(Long id) {
        return analyticsReportRepository.findById(id);
    }

    public List<AnalyticsReport> getReportsByScope(String scope) {
        return analyticsReportRepository.findByScope(scope);
    }

    public AnalyticsReport updateReport(Long id, AnalyticsReport updated) {
        return analyticsReportRepository.findById(id).map(r -> {
            r.setScope(updated.getScope());
            r.setMetrics(updated.getMetrics());
            r.setGeneratedDate(updated.getGeneratedDate());
            return analyticsReportRepository.save(r);
        }).orElseThrow(() -> new ResourceNotFoundException("AnalyticsReport", id));
    }

    public void deleteReport(Long id) {
        analyticsReportRepository.deleteById(id);
    }
}
