package com.yanpao.Configuration.AutomobileConfig;

import com.yanpao.Cars.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *使用@Component等注解（@Repository、@Service、@Controller）注释类时，Spring容器会直接
 * 将这些类转换成为Bean放入容器；如果是业务类代码，可以和项目剥离的类，最好不要使用这种方法
 */
@Component
public class Mustang{

    /**
     * 多种注入方式
     */
    @Autowired
    private Brand Ford;

    private final String name = "Mustang";
    private final Integer cost = 300000;

    public Mustang()
    {

    }

    public Brand GetBrand() {
        return Ford;
    }

    public String GetName() {
        return name;
    }

    public Integer GetCost(){return cost;}



}
