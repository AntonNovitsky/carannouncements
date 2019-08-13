package by.novitsky.carannouncements.dao;

import by.novitsky.carannouncements.entity.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    UserDAO userDAO;

    private UserDAOTest(){
        userDAO = new UserDAO();
    }

    @Test
    public void getAllUsersTest() {
        List<User> users = userDAO.getAllUsers();
        for(User user: users){
            System.out.println(user);
        }
    }

    @Test
    public void getUserByID(){
        User user = userDAO.getUser(1);
        System.out.println(user);
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setId(4);
        user.setName("NameTest");
        userDAO.updateUser(user);
        this.getAllUsersTest();
    }

    @Test
    public void createUser(){
        User user = new User();
        user.setName("NewUser");
        userDAO.createUser(user);
        this.getAllUsersTest();
    }

}