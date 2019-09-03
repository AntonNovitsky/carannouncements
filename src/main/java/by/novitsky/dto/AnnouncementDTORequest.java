package by.novitsky.dto;

import java.time.LocalDateTime;

public class AnnouncementDTORequest {

  private Integer id;
  private Integer carID;
  private LocalDateTime dateCreated;
  private LocalDateTime dateLastChanged;
  private Boolean isActive;

  public AnnouncementDTORequest(){

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

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean active) {
    isActive = active;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
