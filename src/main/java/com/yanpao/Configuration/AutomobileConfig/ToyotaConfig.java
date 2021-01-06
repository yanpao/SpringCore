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
 * <p>现在这种使用@Configuration和@Bean搭配的方式，称作full @Configuration mode，与之对应的是lite @Bean mode，可参考{@link HondaConfig}</p>
 * <ul>
 *     <li>@Bean可以相互依赖，使用CGLIB调用，单例情况下只会存在一个由容器管理的对象</li>
 *     <li>@Bean的方法是不能不能被声明为private和final</li>
 * </ul>
 *
 * <p>一般情况建议使用Full Configuration mode</p>
 *
 * <p>
 *     如果Spring扫描了需要的包并在容器中注册相应的Bean，@Import可以不用加，虽然IDE会警告；
 *     但是Spring没注册相关的Bean，且没有@Import，会报UnsatisfiedDependencyException
 * </p>
 *
 * <p>这里还配置了一些@Autowired的方法，更多的见{@link AutowireConfig}</p>
 */
@Configuration
@Import(JapaneseBrandConfig.class)
public class ToyotaConfig {

    /**
     * 注入方式1：使用Autowired直接注入字段
     */
    @Autowired
    private Brand Toyota1;

    @Bean
    public Automobile Yaris()
    {
        return new Automobile(Toyota1,"Yaris",70000);
    }

    /**
     * 注入方式2：在@Bean函数的参数中，可以指定需要的Bean的name，Spring会自动装配进入，而且也有可能存在为空的情况
     * <p>内部怎么调用？？？？</p>
     */
    @Bean
    public Automobile Levin(Brand Toyota2)
    {
        return new Automobile(Toyota2,"Levin",12000);
    }

    /**
     * 注入方式3：使用构造函数注入，如果这个类只有一个构造函数的情况下，构造函数前的@Autowired可以不用加，如果
     * 有多个，需要用@Autowired标注是注入哪一个构造函数
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

    /**
     * 注入方式4：使用函数和@Autowired进行注入,函数可以是setter函数或者一般函数
     */
    private Brand honda;

    @Autowired
    public void setJapaneseBrand(Brand Honda)
    {
        this.honda=Honda;
    }

    @Bean
    public Automobile Rav4()
    {
        return new Automobile(honda,"Rav4",12000);
    }

    @Bean
    public Automobile setAutomobile(Brand Toyota2)
    {
        return new Automobile(Toyota2,"HighLander",230000);
    }

    /**
     * 多次返回都一样
     */
    public void test()
    {
        System.out.println(Corolla().toString());
    }
}
