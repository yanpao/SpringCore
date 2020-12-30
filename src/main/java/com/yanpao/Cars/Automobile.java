package com.yanpao.Cars;

public class Automobile implements Vehicle {

    private Brand Brand;
    private String Name;
    private Integer Cost;

    public Automobile(Brand brand,String name,Integer cost)
    {
        Brand=brand;
        Name=name;
        Cost=cost;
    }

    public Brand GetBrand() {
        return Brand;
    }

    public String GetName() {
        return Name;
    }

    public Integer GetCost(){return Cost;}
}
