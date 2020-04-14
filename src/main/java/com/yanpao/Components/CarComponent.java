package com.yanpao.Components;

import com.yanpao.Cars.Automobile;
import com.yanpao.Cars.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//“lite” mode
@Component
public class CarComponent {

//    尽量使用构造函数注入
//    @Autowired
//    private Brand brand;

    //private Brand brand;

    //构造函数默认自动注入，可以不用加@Autowired
    //@Autowired
//    public CarComponent(Brand brand){
//        this.brand=brand;
//    }

//    @Autowired
//    public void setBrand(@Qualifier("Honda") Brand brand)
//    {
//        this.brand=brand;
//    }
//
//    @Bean
//    public Automobile Fit()
//    {
//        return new Automobile(brand,"Fit",80000);
//    }

}
