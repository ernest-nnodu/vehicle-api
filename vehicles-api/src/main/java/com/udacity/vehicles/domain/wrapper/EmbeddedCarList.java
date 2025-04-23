package com.udacity.vehicles.domain.wrapper;

import com.udacity.vehicles.domain.car.Car;

import java.util.List;

public class EmbeddedCarList {

    private List<Car> carList;

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
