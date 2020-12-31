package com.yanpao.Configuration.BrandConfig;

import com.yanpao.Cars.Brand;
import org.springframework.context.annotation.Bean;

public class AmericanBrandConfig {

    @Bean
    public Brand Ford()
    {
        return new Brand("Ford","America");
    }

}
