package com.claiminsight360.notifications.controller;

import com.claiminsight360.notifications.entity.Notification;
import com.claiminsight360.notifications.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        return ResponseEntity.ok(notificationService.createNotification(notification));
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        return notificationService.getNotificationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userID}")
    public ResponseEntity<List<Notification>> getNotificationsByUserId(@PathVariable Long userID) {
        return ResponseEntity.ok(notificationService.getNotificationsByUserId(userID));
    }

    @GetMapping("/user/{userID}/unread")
    public ResponseEntity<List<Notification>> getUnreadNotificationsByUserId(@PathVariable Long userID) {
        return ResponseEntity.ok(notificationService.getUnreadNotificationsByUserId(userID));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Notification> updateNotificationStatus(@PathVariable Long id,
                                                                  @RequestParam Notification.Status status) {
        return ResponseEntity.ok(notificationService.updateNotificationStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
}
