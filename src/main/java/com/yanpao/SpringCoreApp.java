package com.yanpao;

import com.yanpao.Cars.Brand;
import com.yanpao.Cars.Car;
import com.yanpao.Configuration.CamryConfiguration;
import com.yanpao.Configuration.LevinConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringCoreApp
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext coreApplicationContext = new AnnotationConfigApplicationContext(LevinConfiguration.class, CamryConfiguration.class);

        Car car = coreApplicationContext.getBean("Camry", Car.class);
        System.out.println( car.GetBrand().GetName()+":"+car.GetBrand().GetNation()+":" +car.GetName()+":"+car.GetCost());

        Brand brand = coreApplicationContext.getBean("Toyota",Brand.class);
        System.out.println(brand.GetName()+":"+brand.GetNation());

//        Car DreamWing = coreApplicationContext.getBean("DreamWing", Car.class);
//        System.out.println( DreamWing.GetBrand()+":" +DreamWing.GetName()+":"+DreamWing.GetCost());


    }
}
