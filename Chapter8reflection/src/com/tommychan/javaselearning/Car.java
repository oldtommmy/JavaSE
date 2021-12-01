package com.tommychan.javaselearning;

public class Car {
    public String brand = "BWM";
    public int price = 400000;
    public String color = "Black";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
