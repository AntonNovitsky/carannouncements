package by.novitsky.dao;


import by.novitsky.entity.Announcement;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementDAO {

    private static final String GET_ALL_ANNOUNCEMENTS_SQL_COMMAND = "SELECT * FROM announcement";
    private static final String GET_ALL_CAR_ANNOUNCEMENTS_SQL_COMMAND = "SELECT * FROM announcement WHERE car_id =";
    private static final String GET_ANNOUNCEMENTS_BY_ID_SQL_COMMAND = "SELECT * FROM announcement WHERE id =";
    private static final String DELETE_ANNOUNCEMENT_BY_ID_SQL_COMMAND = "DELETE FROM announcement WHERE id =";
    private static final String CHANGE_ANNOUNCEMENT_SQL_COMMAND = "UPDATE announcement SET date_last_changed = ?, is_active = ? WHERE id = ?";
    private static final String CREATE_USER_SQL_COMMAND = "INSERT INTO announcement (car_id, date_created, date_last_changed, is_active) VALUES (?,?,?,?)";


    public AnnouncementDAO(){
    }

    public List<Announcement> getAllAnnouncements(){
        ArrayList<Announcement> result = new ArrayList<>();

        try(Connection connection =  DriverManager.getConnection(ConnectionParams.URL_PARAMS);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_ANNOUNCEMENTS_SQL_COMMAND)){
            if (!rs.isBeforeFirst() ) {
                return null;
            }
            while(rs.next()){
                Announcement temp = new Announcement();
                temp.setId(rs.getInt("id"));
                temp.setCarID(rs.getInt("car_id"));
                temp.setDateCreated(rs.getTimestamp("date_created").toLocalDateTime());
                temp.setDateLastChanged(rs.getTimestamp("date_last_changed").toLocalDateTime());
                temp.setActive(rs.getBoolean("is_active"));
                result.add(temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public List<Announcement> getAllAnnouncements(int carID){
        ArrayList<Announcement> result = new ArrayList<>();

        try(Connection connection =  DriverManager.getConnection(ConnectionParams.URL_PARAMS);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_CAR_ANNOUNCEMENTS_SQL_COMMAND + carID)){
            if (!rs.isBeforeFirst() ) {
                return null;
            }
            while(rs.next()){
                Announcement temp = new Announcement();
                temp.setId(rs.getInt("id"));
                temp.setCarID(rs.getInt("car_id"));
                temp.setDateCreated(rs.getTimestamp("date_created").toLocalDateTime());
                temp.setDateLastChanged(rs.getTimestamp("date_last_changed").toLocalDateTime());
                temp.setActive(rs.getBoolean("is_active"));
                result.add(temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Announcement getAnnouncement(int id){
        Announcement result = new Announcement();
        try (Connection connection =  DriverManager.getConnection(ConnectionParams.URL_PARAMS);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(GET_ANNOUNCEMENTS_BY_ID_SQL_COMMAND + id)) {
            if (!rs.isBeforeFirst() ) {
                return null;
            }
            rs.next();
            result.setId(id);
            result.setCarID(rs.getInt("car_id"));
            result.setDateLastChanged(rs.getTimestamp("date_last_changed").toLocalDateTime());
            result.setDateCreated(rs.getTimestamp("date_created").toLocalDateTime());
            result.setActive(rs.getBoolean("is_active"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteAnnouncement(int id){
        try (Connection connection =  DriverManager.getConnection(ConnectionParams.URL_PARAMS);
             Statement statement = connection.createStatement()) {
            statement.execute(DELETE_ANNOUNCEMENT_BY_ID_SQL_COMMAND + id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateAnnouncement(Announcement announcement){
        try (Connection connection =  DriverManager.getConnection(ConnectionParams.URL_PARAMS);
             PreparedStatement statement = connection.prepareStatement(CHANGE_ANNOUNCEMENT_SQL_COMMAND)) {
            statement.setTimestamp(1, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            statement.setBoolean(2, announcement.getActive());
            statement.setInt(3, announcement.getId());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean createAnnouncement(Announcement announcement){
        try (Connection connection =  DriverManager.getConnection(ConnectionParams.URL_PARAMS);
             PreparedStatement statement = connection.prepareStatement(CREATE_USER_SQL_COMMAND)) {
            statement.setInt(1, announcement.getCarID());
            statement.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            statement.setTimestamp(3, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            statement.setBoolean(4, announcement.getActive());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
