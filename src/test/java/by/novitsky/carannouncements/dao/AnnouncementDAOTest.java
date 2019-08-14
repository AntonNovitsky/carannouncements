package by.novitsky.carannouncements.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnnouncementDAOTest {

    @Test
    void getAllAnnouncements() {

        new AnnouncementDAO().getAllAnnouncements().forEach(System.out::println);

    }
}