package com.yanpao.Configuration.BrandConfig;

import com.yanpao.Cars.Brand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GermanicBrandConfig {

    @Bean
    public Brand BMW()
    {
        return new Brand("BMW","Germany");
    }

    @Bean
    public Brand Audi()
    {
        return new Brand("Audi","Germany");
    }

    @Bean
    public Brand BenZ()
    {
        return new Brand("BenZ","Germany");
    }
}
