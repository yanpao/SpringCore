package com.yanpao.Configuration.AutomobileConfig;

import com.yanpao.Cars.Automobile;
import com.yanpao.Cars.Brand;
import com.yanpao.Configuration.BrandConfig.JapaneseBrandConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *Configuration注记用于将业务类注册进入Spring，不侵入原有的类,根据具体的需要对业务类进行配置;
 * <p>现在这种使用@Configuration和Bean搭配的方式，称作full @Configuration mode，与之对应的是lite @Bean mode</p>
 *
 * <p>
 *     如果Spring扫描了需要的包并在容易中注册相应的Bean，@Import可以不用加，虽然IDE会警告；但是Spring没注册相关的Bean，会报UnsatisfiedDependencyException
 * </p>
 */
@Configuration
@Import(JapaneseBrandConfig.class)
public class ToyotaConfig {

    /**
     * 注入方式1：使用Autowired配合Bean的name注入，有可能Bean不在容器中，导致注入失败，此处报错，而且编译器不推荐这种方式
     */
    @Autowired
    private Brand Toyota1;

    @Bean
    public Automobile Yaris()
    {
        return new Automobile(Toyota1,"Yaris",70000);
    }

    /**
     * 注入方式2：在@Bean函数的参数中，可以指定需要的Bean的那么，Spring会自动装配进入，而且也有可能存在为空的情况
     */
    @Bean
    public Automobile Levin(Brand Toyota2)
    {
        return new Automobile(Toyota2,"Levin",12000);
    }

    /**
     * 注入方式3：使用构造函数注入，Spring推荐方式
     */
    private Brand Toyota3;
    public ToyotaConfig(Brand Toyota3)
    {
        this.Toyota3=Toyota3;
    }

    @Bean
    public Automobile Corolla()
    {
        return new Automobile(Toyota3,"Corolla",12000);
    }
}
