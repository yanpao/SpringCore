package com.yanpao.Configuration;

import com.yanpao.Cars.Brand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrandConfig {
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
}
