package com.claiminsight360.iam.service;

import com.claiminsight360.iam.entity.AuditLog;
import com.claiminsight360.iam.entity.User;
import com.claiminsight360.common.exception.ResourceNotFoundException;
import com.claiminsight360.iam.repository.AuditLogRepository;
import com.claiminsight360.iam.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IAMService {

    private final UserRepository userRepository;
    private final AuditLogRepository auditLogRepository;

    public IAMService(UserRepository userRepository, AuditLogRepository auditLogRepository) {
        this.userRepository = userRepository;
        this.auditLogRepository = auditLogRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User updated) {
        return userRepository.findById(id).map(u -> {
            u.setName(updated.getName());
            u.setRole(updated.getRole());
            u.setEmail(updated.getEmail());
            u.setPhone(updated.getPhone());
            return userRepository.save(u);
        }).orElseThrow(() -> new ResourceNotFoundException("User", id));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public AuditLog createAuditLog(AuditLog log) {
        return auditLogRepository.save(log);
    }

    public List<AuditLog> getAllAuditLogs() {
        return auditLogRepository.findAll();
    }

    public List<AuditLog> getAuditLogsByUser(Long userID) {
        return auditLogRepository.findByUserID(userID);
    }
}
