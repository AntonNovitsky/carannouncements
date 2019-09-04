package by.novitsky.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "announcement")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Announcement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "car_id")
  private Car car;

  @Column(name = "date_created")
  private LocalDateTime dateCreated;

  @Column(name = "date_last_changed")
  private LocalDateTime dateLastChanged = LocalDateTime.now();

  @Column(name = "is_active")
  private Boolean isActive = true;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
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
        ", car=" + car.getId() +
        ", dateCreated=" + dateCreated +
        ", dateLastChanged=" + dateLastChanged +
        ", isActive=" + isActive +
        '}';
  }
}

