package by.novitsky.entity;

import java.time.LocalDateTime;

public class Announcement {

    private Integer id;
    private Integer carID;
    private LocalDateTime dateCreated = LocalDateTime.now();
    private LocalDateTime dateLastChanged;
    private Boolean isActive = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarID() {
        return carID;
    }

    public void setCarID(Integer carID) {
        this.carID = carID;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateLastChanged() {
        return dateLastChanged;
    }

    public void setDateLastChanged(LocalDateTime dateLastChanged) {
        this.dateLastChanged = dateLastChanged;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", carID=" + carID +
                ", dateCreated=" + dateCreated +
                ", dateLastChanged=" + dateLastChanged +
                ", isActive=" + isActive +
                '}';
    }
}

