package com.claiminsight360.notifications.repository;

import com.claiminsight360.notifications.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserID(Long userID);
    List<Notification> findByStatus(Notification.Status status);
    List<Notification> findByUserIDAndStatus(Long userID, Notification.Status status);
}
