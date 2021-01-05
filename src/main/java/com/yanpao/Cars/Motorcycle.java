package com.yanpao.Cars;

public class Motorcycle implements Vehicle {

    private Brand Brand;
    private String Name;
    private Integer Cost;

    public Motorcycle(Brand brand,String name,Integer cost)
    {
        Brand=brand;
        Name=name;
        Cost=cost;
    }

    public Brand getBrand() {
        return Brand;
    }

    public String getName() {
        return Name;
    }

    public Integer getCost(){return Cost;}
}
