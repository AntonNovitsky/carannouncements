package by.novitsky.dto;

import by.novitsky.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {

  private Integer id;

  private String name;

  private List<PhoneDTO> phones;


  public UserDTO(User user){
    id = user.getId();
    name = user.getName();
    phones = user.getPhones().stream().map(x -> new PhoneDTO(x)).collect(Collectors.toList());
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<PhoneDTO> getPhones() {
    return phones;
  }

  public void setPhones(List<PhoneDTO> phones) {
    this.phones = phones;
  }

  @Override
  public String toString() {
    return "UserDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", phones=" + phones +
        '}';
  }
}
