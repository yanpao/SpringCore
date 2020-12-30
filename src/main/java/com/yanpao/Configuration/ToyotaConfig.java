package com.yanpao.Configuration;

import com.yanpao.Cars.Automobile;
import com.yanpao.Cars.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *Configuration注记用于将业务类注册进入Spring，不侵入原有的类,根据具体的需要对业务类进行配置;
 */
@Configuration
public class ToyotaConfig {

    /**
     * 注入方式1：使用Autowired配合Bean的name注入，有可能Bean不在容器中，导致注入失败，此处报错，而且编译器不推荐这种方式
     */
    @Autowired
    private Brand Toyota;

    @Bean
    public Automobile Yaris()
    {
        return new Automobile(Toyota,"Yaris",70000);
    }

    @Bean
    public Automobile Levin()
    {
        return new Automobile(Toyota,"Levin",12000);
    }

    @Bean
    public Automobile Corolla()
    {
        return new Automobile(Toyota,"Corolla",12000);
    }
}
