package data.models;

import java.time.LocalDateTime;

public class TrackingInfo {
    private int id;
    private int itemId;
    private String status;
    private String location;
    private LocalDateTime lastUpdated;

    public TrackingInfo(int itemId, String status, String location) {
        this.itemId = itemId;
        this.status = status;
        this.location = location;
        this.lastUpdated = LocalDateTime.now();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        this.lastUpdated = LocalDateTime.now();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        this.lastUpdated = LocalDateTime.now();
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public int getId() {
        return id;
    }
}