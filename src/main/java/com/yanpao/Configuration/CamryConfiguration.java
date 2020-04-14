package com.yanpao.Configuration;

import com.yanpao.Cars.Automobile;
import com.yanpao.Cars.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.yanpao.Configuration.LevinConfiguration;

@Configuration
public class CamryConfiguration {

    //不推荐的自动注入方式
    @Autowired
    private Brand brand;

//构造函数注入
//    @Autowired
//    public CamryConfiguration(Brand brand)
//    {
//        this.brand = brand;
//    }

    //setter注入
//    @Autowired
//    public void setBrand(Brand brand)
//    {
//        this.brand = brand;
//    }

    @Bean
    public Automobile Camry()
    {
        return new Automobile(brand,"Camry",200000);
    }
}
