package com.yanpao.Configuration.BrandConfig;

import com.yanpao.Cars.Brand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JapaneseBrandConfig {

    @Bean
    public Brand Toyota1()
    {
        return new Brand("Toyota1","Japan");
    }

    @Bean
    public Brand Toyota2()
    {
        return new Brand("Toyota2","Japan");
    }

    @Bean
    public Brand Toyota3()
    {
        return new Brand("Toyota3","Japan");
    }

    @Bean
    public Brand Honda()
    {
        return new Brand("Honda","Japan");
    }

    @Bean
    public Brand Nissan()
    {
        return new Brand("Nissan","Japan");
    }

}
