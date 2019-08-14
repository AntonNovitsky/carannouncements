package by.novitsky.carannouncements.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetAnnouncementTest {

    @Test
    void service() {
        System.out.println(new GetAnnouncement().service(1));
    }
}