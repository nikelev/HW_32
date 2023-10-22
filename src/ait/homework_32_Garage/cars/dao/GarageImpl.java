package ait.homework_32_Garage.cars.dao;

import ait.homework_32_Garage.cars.model.Car;

import java.util.function.Predicate;

public class GarageImpl implements Garage {
    private Car[] cars;
    private int sizeActual;

    public GarageImpl(int capacity) {
        cars = new Car[capacity];
    }

    public int getSizeActual() {
        return sizeActual;
    }

    public void setSizeActual(int sizeActual) {
        this.sizeActual = sizeActual;
    }


    @Override
    public boolean addCar(Car car) {
        if (car == null || sizeActual == cars.length || findCarByRegNumber(car.getRegNumber()) != null) {
            return false;
        }
        cars[sizeActual++] = car;
        return true;
    }

    @Override
    public Car removeCar(String regNumber) {
        for (int i = 0; i < sizeActual; i++) {
            if (cars[i].getRegNumber().equals(regNumber)) {
                Car carToRemove = cars[i];
                cars[i] = cars[--sizeActual];
                cars[sizeActual] = null;
                return carToRemove;

            }

        }
        return null;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        for (int i = 0; i < sizeActual; i++) {
            if (cars[i].getRegNumber().equals(regNumber)) {
                return cars[i];
            }
        }
        return null;
    }

    @Override
    public Car[] findCarsByModel(String model) {
        return findCarsByPredicate(c -> c.getModel().equals(model));
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        return findCarsByPredicate(c -> c.getCompany().equals(company));
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        return findCarsByPredicate(c -> c.getEngine() >= min && c.getEngine() < max);
    }

    @Override
    public Car[] findCarsByColor(String color) {
        return findCarsByPredicate(c -> c.getColor().equals(color));
    }

    private Car[] findCarsByPredicate(Predicate<Car> predicate) {
        int count = 0;
        for (int i = 0; i < sizeActual; i++) {
            if (predicate.test(cars[i])) {
                count++;
            }
        }
        Car[] res = new Car[count];
        for (int i = 0, j = 0; j < res.length; i++) {
            if (predicate.test(cars[i])) {
                res[j++] = cars[i];
            }
        }
        return res;
    }

}
