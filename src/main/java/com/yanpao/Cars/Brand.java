package com.yanpao.Cars;

public class Brand {

    private String Name;
    private String Nation;

    public Brand(String name,String nation)
    {
        Name=name;
        Nation=nation;
    }

    public String GetName(){return Name;}

    public String GetNation(){return Nation;}
}
