package com.yanpao.Configuration;

import com.yanpao.Cars.Automobile;
import com.yanpao.Cars.Brand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *Configuration注记用于将业务类注册进入Spring，不侵入原有的类,根据具体的需要对业务类进行配置;
 */
@Configuration
public class ToyotaConfig {

    @Bean
    public Brand Ford()
    {
        return new Brand("Ford","America");
    }

    @Bean
    public Brand Toyota()
    {
        return new Brand("Toyota","Japan");
    }

    @Bean
    public Automobile Yaris()
    {
        return new Automobile(Toyota(),"Yaris",70000);
    }

    @Bean
    public Automobile Levin()
    {
        return new Automobile(Toyota(),"Levin",12000);
    }

    @Bean
    public Automobile Corolla()
    {
        return new Automobile(Toyota(),"Corolla",12000);
    }
}
