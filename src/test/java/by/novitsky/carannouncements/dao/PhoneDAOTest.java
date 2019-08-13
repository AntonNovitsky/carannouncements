package by.novitsky.carannouncements.dao;

import by.novitsky.carannouncements.entity.Phone;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhoneDAOTest {

    PhoneDAO phoneDAO = new PhoneDAO();

    @Test
    public void getPhones(){
        List<Phone> phones = phoneDAO.getUserPhones(1);
        System.out.println(phones);
    }

    @Test
    public void getPhone(){
        System.out.println(phoneDAO.getPhone(1));
    }

}