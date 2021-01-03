package com.yanpao.Configuration.AutomobileConfig;

import com.yanpao.Cars.Brand;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 测试以下接口或者方式：
 * <ul>
 *     <li>@Component</li>
 *     <li>InitializingBean接口</li>
 *     <li>DisposableBean接口</li>
 * </ul>
 * <p>
 *     使用@Component等注解（@Repository、@Service、@Controller）注释类时，Spring容器会直接
 *     将这些类转换成为Bean放入容器；如果是业务类代码，可以和项目剥离的类，最好不要使用这种方法
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
 */
@Component
public class Mustang implements InitializingBean, DisposableBean {

    @Autowired
    private Brand Ford;

    private final String name = "Mustang";
    private final Integer cost = 300000;

    public Mustang()
    {
        System.out.println("Mustang Construct");
    }

    public void afterPropertiesSet()
    {
        System.out.println("Mustang afterPropertiesSet");
    }

    public void destroy() {
        System.out.println("Mustang destroy");
    }

    public Brand GetBrand() {
        return Ford;
    }

    public String GetName() {
        return name;
    }

    public Integer GetCost(){return cost;}



}
