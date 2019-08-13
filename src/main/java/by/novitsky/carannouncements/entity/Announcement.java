package by.novitsky.carannouncements.entity;

import java.time.LocalDateTime;

public class Announcement {

    private int id;
    private int carID;
    private LocalDateTime dateCreated;
    private LocalDateTime dateLastChanged;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
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

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", carID=" + carID +
                ", dateCreated=" + dateCreated +
                ", dateLastChanged=" + dateLastChanged +
                '}';
    }
}

