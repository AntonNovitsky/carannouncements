package by.novitsky.dao;


import by.novitsky.cofiguration.ConfigurationManager;
import by.novitsky.entity.Phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAO {

  private static final String GET_USER_PHONES_SQL_COMMAND = "SELECT * FROM phone WHERE user_id = ";
  private static final String GET_PHONE_BY_ID_SQL_COMMAND = "SELECT * FROM phone WHERE id =";
  private static final String DELETE_PHONE_BY_ID_SQL_COMMAND = "DELETE FROM phone WHERE id = ";
  private static final String CHANGE_PHONE_SQL_COMMAND = "UPDATE phone SET number = ? WHERE id = ?";
  private static final String CREATE_PHONE_SQL_COMMAND = "INSERT INTO phone (user_id, number) VALUES (?,?)";


  public PhoneDAO() {
  }

  public List<Phone> getUserPhones(int userID) {
    List<Phone> result = new ArrayList<>();

    try (Connection connection = DriverManager.getConnection(ConfigurationManager.getUrl());
         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(GET_USER_PHONES_SQL_COMMAND + userID)) {
      if (!rs.isBeforeFirst()) {
        return null;
      }
      while (rs.next()) {
        Phone temp = new Phone();
        temp.setId(rs.getInt("id"));
        temp.setUserID(userID);
        temp.setNumber(rs.getString("number"));
        result.add(temp);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  public Phone getPhone(int id) {
    Phone result = new Phone();
    try (Connection connection = DriverManager.getConnection(ConfigurationManager.getUrl());
         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(GET_PHONE_BY_ID_SQL_COMMAND + id)) {
      if (!rs.isBeforeFirst()) {
        return null;
      }
      rs.next();
      result.setId(id);
      result.setNumber(rs.getString("number"));
      result.setUserID(rs.getInt("user_id"));

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  public boolean deletePhone(int id) {
    try (Connection connection = DriverManager.getConnection(ConfigurationManager.getUrl());
         Statement statement = connection.createStatement()) {
      statement.execute(DELETE_PHONE_BY_ID_SQL_COMMAND + id);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean updatePhone(Phone phone) {
    try (Connection connection = DriverManager.getConnection(ConfigurationManager.getUrl());
         PreparedStatement statement = connection.prepareStatement(CHANGE_PHONE_SQL_COMMAND)) {
      statement.setString(1, phone.getNumber());
      statement.setInt(2, phone.getId());
      statement.execute();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean createPhone(Phone phone) {
    try (Connection connection = DriverManager.getConnection(ConfigurationManager.getUrl());
         PreparedStatement statement = connection.prepareStatement(CREATE_PHONE_SQL_COMMAND)) {
      statement.setInt(1, phone.getUserID());
      statement.setString(2, phone.getNumber());
      statement.execute();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

}
