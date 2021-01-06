package com.yanpao.Configuration.AutomobileConfig;

import com.yanpao.Cars.Automobile;
import com.yanpao.Cars.Brand;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 实验lite @Bean mode，与之对应的full @Configuration mode参考{@link com.yanpao.Configuration.AutomobileConfig.ToyotaConfig}.
 * <ul>
 *     <li>lite mode在类处不注释@Configuration，可以注释@Component或者不注释，但在方法上注释@Bean</li>
 *     <li>@Bean方法不会被CGLIB代理,因此每次方法被调用会生成不同的对象</li>
 *     <li>某些情况下可以使用，比如service组件可以对容器暴露view，这种情况下@Bean为工厂方法</li>
 * </ul>
 *
 * <p>为了避免出现一些莫名其妙的问题，不要使用lite @Bean mode</p>
 */
@Component
public class HondaConfig {

    private Brand Honda;
    public HondaConfig(Brand Honda)
    {
        this.Honda=Honda;
    }

    @Bean
    public Automobile Fit()
    {
        return new Automobile(Honda,"Fit",70000);
    }

    /**
     * 多次返回都不一样
     */
    public void test()
    {
        System.out.println(Fit().toString());
    }
}
