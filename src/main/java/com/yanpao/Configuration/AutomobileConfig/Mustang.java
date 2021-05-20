package com.yanpao.Configuration.AutomobileConfig;

import com.yanpao.Cars.Brand;
import com.yanpao.Cars.Vehicle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 测试以下接口或者方式：
 * <ul>
 *     <li>@Component</li>
 *     <li>InitializingBean接口</li>
 *     <li>DisposableBean接口</li>
 *     <li>ApplicationContextAware</li>
 *     <li>BeanNameAware</li>
 * </ul>
 * <p>
 *     使用@Component等注解（@Repository、@Service、@Controller）注释类时，Spring容器会直接
 *     将这些类转换成为Bean放入容器，这些类应视为框架类，无法从项目中剥离，复用性比较差；
 *     如果是业务类代码，可以和项目剥离的类，最好不要使用这种方法
 * </p>
 *
 * <p>
 *     继承InitializingBean接口，实现afterPropertiesSet，Spring会在容器设置好所有参数后
 *     调用afterPropertiesSet方法；官方建议不要使用这种方法，因为会和Spring框架耦合。
 * </p>
 *
 * <p>
 *     继承DisposableBean接口，实现destroy，Spring会在容器关闭后
 *     调用destroy方法；官方建议不要使用这种方法，因为会和Spring框架耦合。
 * </p>
 *
 * <p>
 *      继承ApplicationContextAware的类在容器创建这个类的Bean之后回调setApplicationContext方法，可以获取到ApplicationContext，
 *      Spring官方不建议这种方法，会和Spring框架耦合。另外还可以使用@Autowired注入ApplicationContext。
 * </p>
 *
 * <p>
 *     继承BeanNameAware的类会在容器容器设置Bean的属性之后，在回调初始化方法之前（init-method）调用setBeanName方法，可以获取
 *     Bean的名称。
 * </p>
 */
@Component
public class Mustang implements Vehicle,
        InitializingBean,
        DisposableBean,
        ApplicationContextAware,
        BeanNameAware, BeanPostProcessor, BeanFactoryAware {

    private Brand brand;
    private String name = "Mustang";
    private Integer cost = 300000;

    public Mustang()
    {
        System.out.println("Mustang Construct");
        this.brand = new Brand("Changan","China");
    }

    /**
     * Populate Properties就是为Spring的Bean自动注入依赖
     */
//    @Autowired
//    public void setBrand(Brand Ford) {
//        System.out.println("Mustang Populate Properties :Ford");
//        this.brand=Ford;
//    }

    /**
     * 在容器容器设置Bean的属性之后，在回调初始化方法之前（init-method）调用setBeanName方法
     * @param name Bean的名称
     * @throws BeansException
     */
    public void setBeanName(String name) throws BeansException
    {
        System.out.println("Mustang BeanNameAware setBeanName()");
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException{
        System.out.println("Mustang BeanFactoryAware setBeanFactory()");
    }

    /**
     * 容器在调用构造函数新建这个Bean后，会回调setApplicationContext方法
     * @param applicationContext 创建这个Bean的Spring容器
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        System.out.println("Mustang ApplicationContextAware setApplicationContext()");
    }

    @PostConstruct
    public void init(){
        System.out.println("Mustang PostConstruct");
    }

    public void afterPropertiesSet()
    {
        System.out.println("Mustang afterPropertiesSet");
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Mustang PostProcess Before Initialization : " +  beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Mustang PostProcess After Initialization : " +  beanName);
        return bean;
    }

    public void destroy() {
        System.out.println("Mustang destroy");
    }

    public Brand getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public Integer getCost(){return cost;}

    public void setName(String name) {
        System.out.println("Mustang setName()");
        this.name = name;
    }

    public void setCost(Integer cost) {
        System.out.println("Mustang cost()");
        this.cost = cost;
    }







}
