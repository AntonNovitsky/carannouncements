package by.novitsky.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "year_of_production")
  private Integer yearOfProduction;

  private String brand;
  private String model;

  @Column(name = "engine_capacity")
  private Integer engineCapacity;

  @Enumerated(EnumType.STRING)
  private Condition condition;

  private Integer mileage;

  @Column(name = "engine_power")
  private Integer enginePower;

  @OneToMany
  @JoinColumn(name = "car_id")
  //@LazyCollection(LazyCollectionOption.FALSE)
  @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  private List<Announcement> announcementList;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Integer getYearOfProduction() {
    return yearOfProduction;
  }

  public void setYearOfProduction(Integer yearOfProduction) {
    this.yearOfProduction = yearOfProduction;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getEngineCapacity() {
    return engineCapacity;
  }

  public void setEngineCapacity(Integer engineCapacity) {
    this.engineCapacity = engineCapacity;
  }

  public Condition getCondition() {
    return condition;
  }

  public void setCondition(Condition condition) {
    this.condition = condition;
  }

  public Integer getMileage() {
    return mileage;
  }

  public void setMileage(Integer mileage) {
    this.mileage = mileage;
  }

  public Integer getEnginePower() {
    return enginePower;
  }

  public void setEnginePower(Integer enginePower) {
    this.enginePower = enginePower;
  }

  public List<Announcement> getAnnouncementList() {
    return announcementList;
  }

  public void setAnnouncementList(List<Announcement> announcementList) {
    this.announcementList = announcementList;
  }

  @Override
  public String toString() {
    return "Car{" +
        "id=" + id +
        ", user=" + user.getName() +
        ", yearOfProduction=" + yearOfProduction +
        ", brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        ", engineCapacity=" + engineCapacity +
        ", condition=" + condition +
        ", mileage=" + mileage +
        ", enginePower=" + enginePower +
        ", announcementList=" + announcementList +
        '}';
  }
}
