package com.claiminsight360.notifications.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationID;

    private Long userID;

    @Column(length = 1000)
    private String message;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdDate;

    public enum Category {
        RISK, DENIAL, COST, PERFORMANCE
    }

    public enum Status {
        UNREAD, READ, DISMISSED
    }

    public Notification() {}

    public Notification(Long userID, String message, Category category, Status status, LocalDateTime createdDate) {
        this.userID = userID;
        this.message = message;
        this.category = category;
        this.status = status;
        this.createdDate = createdDate;
    }

    public Long getNotificationID() { return notificationID; }
    public void setNotificationID(Long notificationID) { this.notificationID = notificationID; }
    public Long getUserID() { return userID; }
    public void setUserID(Long userID) { this.userID = userID; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }
}
