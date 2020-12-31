package com.yanpao.Configuration.LuxuryAutoConfig;

import com.yanpao.Cars.Automobile;
import com.yanpao.Cars.Brand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AudiConfig {

    private Brand Audi;

    public AudiConfig(Brand Audi)
    {
        this.Audi= Audi;
    }

    @Bean
    public Automobile A4()
    {
        return new Automobile(Audi,"A4",300000);
    }

}
