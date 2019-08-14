package by.novitsky.carannouncements.dao;

import by.novitsky.carannouncements.entity.Announcement;
import by.novitsky.carannouncements.entity.Car;
import by.novitsky.carannouncements.entity.Condition;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

    private static final String GET_CAR_BY_ID_SQL_COMMAND = "SELECT * FROM car WHERE id =";
    private static final String GET_ALL_USER_CARS_SQL_COMMAND = "SELECT * FROM car WHERE user_id =";
    private static final String DELETE_CAR_BY_ID_SQL_COMMAND = "DELETE FROM car WHERE id = ";
    private static final String CHANGE_CAR_SQL_COMMAND
            = "UPDATE car SET year_of_production = ?, brand = ?, model = ?, engine_capacity = ?, condition = ?, mileage = ?, engine_power= ? WHERE id = ?";
    private static final String CREATE_CAR_SQL_COMMAND
        = "INSERT INTO car (year_of_production, brand, model, engine_capacity, condition, mileage, engine_power, user_id) VALUES (?,?,?,?,?,?,?,?)";


    public List<Car> getAllUserCars(int userID){
        ArrayList<Car> result = new ArrayList<>();

        try (Connection connection =  DriverManager.getConnection(ConnectionParams.URL_PARAMS);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(GET_ALL_USER_CARS_SQL_COMMAND + userID)) {
            while(rs.next()){
                Car temp = new Car();
                int id = rs.getInt("id");
                result.add(this.getCar(id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public boolean deleteCar(int id){
        try (Connection connection =  DriverManager.getConnection(ConnectionParams.URL_PARAMS);
             Statement statement = connection.createStatement()) {
            statement.execute(DELETE_CAR_BY_ID_SQL_COMMAND + id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Car getCar(int id){
        Car result = new Car();
        try (Connection connection =  DriverManager.getConnection(ConnectionParams.URL_PARAMS);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(GET_CAR_BY_ID_SQL_COMMAND + id)) {
            while(rs.next()){
                result.setId(id);
                result.setUserID(rs.getInt("user_id"));
                result.setYearOfProduction(rs.getInt("year_of_production"));
                result.setBrand(rs.getString("brand"));
                result.setModel(rs.getString("model"));
                result.setEngineCapacity(rs.getInt("engine_capacity"));
                result.setCondition(Condition.valueOf(rs.getString("condition")));
                result.setMileage(rs.getInt("mileage"));
                result.setEnginePower(rs.getInt("engine_power"));
                result.setAnnouncementList(new AnnouncementDAO().getAllAnnouncements(id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean updateCar(Car car){
        try (Connection connection =  DriverManager.getConnection(ConnectionParams.URL_PARAMS);
             PreparedStatement statement = connection.prepareStatement(CHANGE_CAR_SQL_COMMAND)) {
            statement.setInt(1, car.getYearOfProduction());
            statement.setString(2, car.getBrand());
            statement.setString(3, car.getModel());
            statement.setInt(4, car.getEngineCapacity());
            statement.setString(5,car.getCondition().toString());
            statement.setInt(6, car.getMileage());
            statement.setInt(7, car.getEnginePower());
            statement.setInt(8, car.getId());
            statement.execute();
            AnnouncementDAO announcementDAO = new AnnouncementDAO();
            List<Announcement> announcements = announcementDAO.getAllAnnouncements(car.getId());
            announcements.forEach((x) -> announcementDAO.updateAnnouncement(x));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean createCar(Car car){
        try (Connection connection =  DriverManager.getConnection(ConnectionParams.URL_PARAMS);
             PreparedStatement statement = connection.prepareStatement(CREATE_CAR_SQL_COMMAND)) {
            statement.setInt(1, car.getYearOfProduction());
            statement.setString(2, car.getBrand());
            statement.setString(3, car.getModel());
            statement.setInt(4, car.getEngineCapacity());
            statement.setString(5,car.getCondition().toString());
            statement.setInt(6, car.getMileage());
            statement.setInt(7, car.getEnginePower());
            statement.setInt(8, car.getUserID());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
