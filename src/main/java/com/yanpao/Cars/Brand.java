package com.yanpao.Cars;

import org.springframework.beans.factory.BeanNameAware;

public class Brand implements BeanNameAware {

    private String Name;
    private String Nation;
    private String BeanName;

    public Brand(String name,String nation) {
        Name=name;
        Nation=nation;
    }

    public String getName(){return Name;}

    public String getNation(){return Nation;}

    public void setBeanName(String name)
    {
        BeanName = name;
    }

    public String getBeanName()
    {
        return BeanName;
    }
}
