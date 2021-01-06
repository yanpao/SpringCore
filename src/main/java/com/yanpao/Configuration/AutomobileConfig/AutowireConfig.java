package com.yanpao.Configuration.AutomobileConfig;

import com.yanpao.Cars.Brand;
import com.yanpao.Cars.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 测试自动注入，Spring会将所有实现Vehicle接口的类全部注入到List中
 */
@Configuration
public class AutowireConfig {

    @Autowired
    private Brand brand_No_Name;

    @Autowired
    @Qualifier("Toyota1")
    private Brand brand_Qualifier1;

    @Autowired
    @Qualifier("Toyota2_2")
    private Brand brand_Qualifier2;

    @Autowired
    private Brand Toyota3;

    public void autowireBrand(){
        System.out.println(brand_No_Name.getName() + ":" + brand_No_Name.getNation()+":"+brand_No_Name.getBeanName());
        System.out.println(brand_Qualifier1.getName() + ":" + brand_Qualifier1.getNation()+":"+brand_Qualifier1.getBeanName());
        System.out.println(brand_Qualifier2.getName() + ":" + brand_Qualifier2.getNation()+":"+brand_Qualifier2.getBeanName());
        System.out.println(Toyota3.getName() + ":" + Toyota3.getNation()+":"+Toyota3.getBeanName());
    }

    @Autowired
    List<Vehicle> allVehicles;

    public void autowireList()
    {
        for (Vehicle vehicle:allVehicles)
        {
            System.out.println(vehicle.getName()+ ":" + vehicle.getCost()
                    + ":" + vehicle.getBrand().getName()+ ":" + vehicle.getBrand().getNation());
        }
    }




}
