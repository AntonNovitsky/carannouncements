package by.novitsky.dto;

import by.novitsky.entity.Announcement;

import java.time.LocalDateTime;

public class AnnouncementDTO {

  private Integer id;

  private LocalDateTime dateCreated;

  private LocalDateTime dateLastChanged;

  private Boolean isActive;

  private CarDTO car;

  private UserDTO user;

  public AnnouncementDTO(Announcement announcement) {
    id = announcement.getId();
    dateCreated = announcement.getDateCreated();
    dateLastChanged = announcement.getDateLastChanged();
    isActive = announcement.getActive();
    car = new CarDTO(announcement.getCar());
    user = new UserDTO(announcement.getCar().getUser());
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public CarDTO getCar() {
    return car;
  }

  public void setCar(CarDTO car) {
    this.car = car;
  }

  public UserDTO getUser() {
    return user;
  }

  public void setUser(UserDTO user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "AnnouncementDTO{" +
        "id=" + id +
        ", dateCreated=" + dateCreated +
        ", dateLastChanged=" + dateLastChanged +
        ", isActive=" + isActive +
        ", car=" + car +
        ", user=" + user +
        '}';
  }
}
