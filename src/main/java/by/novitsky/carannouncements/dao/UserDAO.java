package by.novitsky.carannouncements.dao;

import by.novitsky.carannouncements.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final String GET_ALL_USERS_SQL_COMMAND = "SELECT * FROM car_user";
    private static final String GET_USER_BY_ID_SQL_COMMAND = "SELECT * FROM car_user WHERE id = ";
    private static final String DELETE_USER_BY_ID_SQL_COMMAND = "DELETE FROM car_user WHERE id = ";
    private static final String CREATE_USER_SQL_COMMAND = "INSERT INTO car_user (name) VALUES (?)";
    private static final String CHANGE_USER_SQL_COMMAND = "UPDATE car_user SET name = ? WHERE id = ?";

    public UserDAO(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();

        try (Connection connection =  DriverManager.getConnection(ConnectionParams.URL_PARAMS);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(GET_ALL_USERS_SQL_COMMAND)) {
            if (!rs.isBeforeFirst() ) {
                return null;
            }
            while(rs.next()){
                User tempUser = new User();
                int id = rs.getInt("id");
                result.add(this.getUser(id));
                /*tempUser.setId(rs.getInt("id"));-
                tempUser.setName(rs.getString("name"));
                tempUser.setPhones(new PhoneDAO().getUserPhones(tempUser.getId()));
                result.add(tempUser);*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public User getUser(int id){
        User result = new User();
        try (Connection connection =  DriverManager.getConnection(ConnectionParams.URL_PARAMS);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(GET_USER_BY_ID_SQL_COMMAND + id)) {
            if (!rs.isBeforeFirst() ) {
                return null;
            }
            rs.next();
            result.setId(id);
            result.setName(rs.getString("name"));
            result.setPhones(new PhoneDAO().getUserPhones(id));
            result.setCars(new CarDAO().getAllUserCars(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteUser(int id){
        try (Connection connection =  DriverManager.getConnection(ConnectionParams.URL_PARAMS);
             Statement statement = connection.createStatement()) {
            statement.execute(DELETE_USER_BY_ID_SQL_COMMAND + id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateUser(User user){
        try (Connection connection =  DriverManager.getConnection(ConnectionParams.URL_PARAMS);
             PreparedStatement statement = connection.prepareStatement(CHANGE_USER_SQL_COMMAND)) {
            statement.setString(1, user.getName());
            statement.setInt(2, user.getId());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean createUser(User user){
        try (Connection connection =  DriverManager.getConnection(ConnectionParams.URL_PARAMS);
             PreparedStatement statement = connection.prepareStatement(CREATE_USER_SQL_COMMAND)) {
            statement.setString(1, user.getName());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}