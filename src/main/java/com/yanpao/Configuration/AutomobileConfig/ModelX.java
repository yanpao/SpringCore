package com.yanpao.Configuration.AutomobileConfig;

import com.yanpao.Cars.Brand;
import com.yanpao.Cars.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *用来测试没有注册的Bean
 */
@Component
public class ModelX implements Vehicle {

    @Autowired
    private Brand Ford;

    private final String name = "ModelX";
    private final Integer cost = 250000;

    public ModelX()
    {

    }

    public Brand getBrand() {
        return Ford;
    }

    public String getName() {
        return name;
    }

    public Integer getCost(){return cost;}
}
