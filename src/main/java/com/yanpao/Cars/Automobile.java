package com.yanpao.Cars;

public class Automobile implements Car {

    private Brand Brand;
    private String Name;
    private Integer Cost;

    public Automobile(Brand brand,String name,Integer cost)
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
