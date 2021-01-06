package com.yanpao.Configuration.AutomobileConfig;

import com.yanpao.Cars.Brand;
import com.yanpao.Cars.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * 测试以下接口或者方式：
 * <ul>
 *   <li>@PostConstruct</li>
 *   <li>@PreDestroy</li>
 *</ul>
 * 这两个注释来自JSR-250，被普遍认为是现阶段Spring应用的最佳lifecycle回调方式，不会产生和Spring的耦合。
 *
 * <p>
 *      javax.annotation包6-8都是标准包，9已经与java核心分离，11已经删除，需要用的话需要使用maven引用。
 * </p>
 */
@Component
public class Aventador implements Vehicle {

    @Autowired
    private Brand Ford;

    private final String name = "Aventador";
    private final Integer cost = 8000000;

    @PostConstruct
    public void afterPropertiesSet()
    {
        System.out.println("Aventador afterPropertiesSet");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Aventador destroy");
    }

    public Brand getBrand() {
        return Ford;
    }

    public String getName() {
        return name;
    }

    public Integer getCost(){return cost;}
}
