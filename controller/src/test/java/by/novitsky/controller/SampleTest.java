package by.novitsky.controller;

import by.novitsky.service.GetAllAnnouncements;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SampleTest {

    @Test
    public void printHello(){
        System.out.println(new GetAllAnnouncements().service().toString());
    }

}