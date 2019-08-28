package by.novitsky.dto;

import by.novitsky.entity.Car;
import by.novitsky.entity.Condition;

public class CarDTO {

  private Integer id;

  private Integer yearOfProduction;

  private String brand;
  private String model;

  private Integer engineCapacity;

  private Condition condition;

  private Integer mileage;

  private Integer enginePower;


  public CarDTO(Car car){
    id = car.getId();
    yearOfProduction = car.getYearOfProduction();
    brand = car.getBrand();
    model = car.getModel();
    engineCapacity = car.getEngineCapacity();
    condition = car.getCondition();
    mileage = car.getMileage();
    enginePower = car.getEnginePower();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  @Override
  public String toString() {
    return "CarDTO{" +
        "id=" + id +
        ", yearOfProduction=" + yearOfProduction +
        ", brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        ", engineCapacity=" + engineCapacity +
        ", condition=" + condition +
        ", mileage=" + mileage +
        ", enginePower=" + enginePower +
        '}';
  }
}
