package ait.homework_32_Garage.cars.test;

import ait.homework_32_Garage.cars.dao.Garage;
import ait.homework_32_Garage.cars.dao.GarageImpl;
import ait.homework_32_Garage.cars.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageImplTest {
    Garage garage;
    Car[] cars;


    @BeforeEach
    void setUp() {
        garage=new GarageImpl(5);
        cars=new Car[4];
        cars[0]=new Car("111", "325", "BMW",2.5, "black");
        cars[1]=new Car("222", "530", "BMW",3.0, "black");
        cars[2]=new Car("333", "80", "Audi",2.0, "white");
        cars[3]=new Car("444", "C180", "Mercedes",1.8, "grey");

    }

    @Test
    void addCar() {
        assertFalse(garage.addCar(null));
        assertFalse(garage.addCar(cars[1]));
        Car car  = new Car("555", "E220", "Mercedes",2.2, "blue");
        assertTrue(garage.addCar(car));
        car  = new Car("666", "E220", "Mercedes",2.2, "blue");
        assertFalse(garage.addCar(car));

    }

    @Test
    void removeCar() {
        Car car=garage.removeCar("111");
        assertEquals(cars[0],car);
        assertNull(garage.removeCar("111"));
    }

    @Test
    void findCarByRegNumber() {
        assertEquals(cars[1],garage.findCarByRegNumber("222"));
        assertNull(garage.findCarByRegNumber("555"));

    }

    @Test
    void findCarsByModel() {
        assertEquals(cars[1],garage.findCarsByModel("530"));
        assertNull(garage.findCarsByModel("000"));
    }

    @Test
    void findCarsByCompany() {
        assertEquals(cars[2], garage.findCarsByCompany("Audi"));
        assertNull(garage.findCarsByCompany("XXX"));
    }

    @Test
    void findCarsByEngine() {
        assertEquals(cars[1], garage.findCarsByEngine(1.9, 2.1));
    }

    @Test
    void findCarsByColor() {
        assertEquals(cars[2], garage.findCarsByColor("white"));
    }
}