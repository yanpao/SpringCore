package com.yanpao.Configuration.BrandConfig;

import com.yanpao.Cars.Brand;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JapaneseBrandConfig {

    /**
     * 注意此处@Primary，如果使用@Primary，其他所有注入的地方，如果没有使用@Qualifier，都会被注入这个@Primary
     */
    @Bean
    //@Primary
    public Brand Toyota()
    {
        return new Brand("Toyota","Japan");
    }

    @Bean
    public Brand Toyota1()
    {
        return new Brand("Toyota1","Japan");
    }

    @Bean
    @Qualifier("Toyota2_2")
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

}
