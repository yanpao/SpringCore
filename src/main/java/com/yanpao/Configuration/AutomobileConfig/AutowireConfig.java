package com.yanpao.Configuration.AutomobileConfig;

import com.yanpao.Cars.Brand;
import com.yanpao.Cars.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 测试自动注入，@Autowired是按照类型自动注入的，如果容器中有多个相同类型的Bean，
 * <ul>
 *     <li>注入时如果使用@Qualifier指定了BeanName或者别名，直接注入，因为很明确；@Qualifier也可以使用在函数参数上</li>
 *     <li>如果没有指定名称，优先使用@Primary的Bean进行注入</li>
 *     <li>再不行，用@Autowired注释的字段的字段名或者@Autowired注释的函数的参数的名称匹配名称进行匹配，有匹配结果的注入，没有报错</li>
 * </ul>
 * Spring会将所有实现Vehicle接口的类全部注入到List中
 */
@Configuration
public class AutowireConfig {

    /**
     * Autiwired 是使用类型进行注入，如果有多个类型的话，容器不知道使用哪一个Bean，会报异常
     * 此处使用@Qualifier指定要注入的Brand的BeanName
     */
    @Autowired
    @Qualifier("Toyota1")
    private Brand brand_Qualifier1;

    /**
     * 用@Qualifier指定要注入Brand的Bean的别名
     */
    @Autowired
    @Qualifier("Toyota2_2")
    private Brand brand_Qualifier2;

    /**
     * 如果字段的名称或者构造函数的参数的名称，可以和待注入的多个Brand Bean中的一个的BeanName吻合，可以准确的注入。
     * 如果没有吻合的话，在Brand声明时对某一个使用@Primary，会优先找到这个定义。但是其他的没有使用@Qualifier指定要注入Brand Bean
     * 都会注入@Primary指定的Bean。
     */
    @Autowired
    private Brand Toyota3;

    public void autowireBrand(){
        System.out.println(brand_Qualifier1.getName() + ":" + brand_Qualifier1.getNation()+":"+brand_Qualifier1.getBeanName());
        System.out.println(brand_Qualifier2.getName() + ":" + brand_Qualifier2.getNation()+":"+brand_Qualifier2.getBeanName());
        System.out.println(Toyota3.getName() + ":" + Toyota3.getNation()+":"+Toyota3.getBeanName());
    }

    /**
     * 使用@Autowired可以将所有相同类型的Bean或者继承同一接口的Bean注入到List、Array、Set中，
     * 也可以注入到Map中，value是Bean，对应的key值是BeanName。
     * <p>可以在Bean声明处使用@Order或者@Priority，规定List中Bean的顺序</p>
     */
    @Autowired
    private List<Vehicle> vehicleList;

    @Autowired
    private Vehicle[] vehicles;

    @Autowired
    private Set<Vehicle> vehicleSet;

    @Autowired
    private Map<String,Vehicle> vehiclesMap;

    /**
     * 如果将@Autowired注释为required为false，如果找不到也不会报错，找到了就注入
     */
    @Autowired(required = false)
    @Qualifier("BYD")
    private Brand BYD;

    /**
     * 可以直接使用@Autowired注入BeanFactory, ApplicationContext, Environment, ResourceLoader, ApplicationEventPublisher, and
     * MessageSource等对象
     */
    @Autowired
    private ApplicationContext context;




}
