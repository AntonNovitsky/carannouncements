package by.novitsky.carannouncements.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetAllAnnouncementsTest {

    @Test
    public void getAllAnnouncements(){
        System.out.println(new GetAllAnnouncements().service());
    }

}