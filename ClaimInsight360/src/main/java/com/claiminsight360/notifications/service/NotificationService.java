package com.claiminsight360.notifications.service;

import com.claiminsight360.notifications.entity.Notification;
import com.claiminsight360.common.exception.ResourceNotFoundException;
import com.claiminsight360.notifications.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    public List<Notification> getNotificationsByUserId(Long userID) {
        return notificationRepository.findByUserID(userID);
    }

    public List<Notification> getNotificationsByStatus(Notification.Status status) {
        return notificationRepository.findByStatus(status);
    }

    public List<Notification> getUnreadNotificationsByUserId(Long userID) {
        return notificationRepository.findByUserIDAndStatus(userID, Notification.Status.UNREAD);
    }

    public Notification updateNotificationStatus(Long id, Notification.Status status) {
        return notificationRepository.findById(id).map(n -> {
            n.setStatus(status);
            return notificationRepository.save(n);
        }).orElseThrow(() -> new ResourceNotFoundException("Notification", id));
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
