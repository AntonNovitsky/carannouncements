package by.novitsky.carannouncements.dao;

import by.novitsky.carannouncements.entity.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarDAOTest {

    CarDAO carDAO;

    CarDAOTest(){
        carDAO = new CarDAO();
    }

    @Test
    public void getAllCars(){
        System.out.println(carDAO.getAllUserCars(1));
    }

    @Test
    public void updateCar(){
        Car car = carDAO.getCar(1);
        System.out.println(car);
        car.setModel("CarModel");
        carDAO.updateCar(car);
        System.out.println(carDAO.getCar(1));
    }

    @Test
    public void createCar(){
        Car car = carDAO.getCar(1);
        carDAO.createCar(car);
        getAllCars();
    }

    @Test
    public void deleteCar(){
        carDAO.deleteCar(4);
        getAllCars();
    }

}