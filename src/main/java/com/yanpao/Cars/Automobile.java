package com.yanpao.Cars;

public class Automobile implements Vehicle {

    private Brand Brand;
    private String Name;
    private Integer Cost;

    public Automobile()
    {
    }

    public Automobile(Brand brand)
    {
        Brand=brand;
    }

    public Automobile(Brand brand,String name,Integer cost)
    {
        Brand=brand;
        Name=name;
        Cost=cost;
    }

    public void setBrand(com.yanpao.Cars.Brand brand) {
        Brand = brand;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCost(Integer cost) {
        Cost = cost;
    }

    public Brand getBrand() {
        return Brand;
    }

    public String getName() {
        return Name;
    }

    public Integer getCost(){return Cost;}
}
