package com.yanpao.Configuration;

import com.yanpao.Cars.Automobile;
import com.yanpao.Cars.Brand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//最基本使用@Configuration配置Bean
@Configuration
public class LevinConfiguration {

//    @Bean
//    public Automobile Levin()
//    {
//        return new Automobile(Toyota(),"Levin",100000);
//    }

//    @Bean
//    public Brand Toyota()
//    {
//        return new Brand("Toyota","Japan");
//    }

    @Bean
    public Brand Toyota()
    {
        return null;
    }
}
