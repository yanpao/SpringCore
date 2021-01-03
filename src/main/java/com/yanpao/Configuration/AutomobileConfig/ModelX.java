package com.yanpao.Configuration.AutomobileConfig;

import com.yanpao.Cars.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *用来测试没有注册的Bean
 */
@Component
public class ModelX {

    @Autowired
    private Brand Ford;

    private final String name = "ModelX";
    private final Integer cost = 250000;

    public ModelX()
    {

    }

    public Brand GetBrand() {
        return Ford;
    }

    public String GetName() {
        return name;
    }

    public Integer GetCost(){return cost;}
}
