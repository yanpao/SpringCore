package com.yanpao.Cars;

public class Motorcycle implements Car {

    private Brand Brand;
    private String Name;
    private Integer Cost;

    public Motorcycle(Brand brand,String name,Integer cost)
    {
        Brand=brand;
        Name=name;
        Cost=cost;
    }

    @Override
    public Brand GetBrand() {
        return Brand;
    }

    @Override
    public String GetName() {
        return Name;
    }

    @Override
    public Integer GetCost(){return Cost;}
}
