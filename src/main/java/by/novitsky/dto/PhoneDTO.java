package by.novitsky.dto;

import by.novitsky.entity.Phone;

public class PhoneDTO {

  private Integer id;

  private String number;

  public PhoneDTO(Phone phone){
    id = phone.getId();
    number = phone.getNumber();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return "PhoneDTO{" +
        "id=" + id +
        ", number='" + number + '\'' +
        '}';
  }
}
