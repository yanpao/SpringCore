package com.yanpao;

import com.yanpao.Cars.Brand;
import com.yanpao.Configuration.Mustang;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringCoreApp
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext coreApplicationContext = new AnnotationConfigApplicationContext();
        coreApplicationContext.scan("com.yanpao");
        coreApplicationContext.refresh();

        try {
            Brand toyota = coreApplicationContext.getBean("Toyota", Brand.class);
            System.out.println(toyota.GetName() + ":" + toyota.GetNation());

            Mustang mustang = coreApplicationContext.getBean("mustang", Mustang.class);
            System.out.println(mustang.GetName()+ ":" + mustang.GetCost()
                    + ":" + mustang.GetBrand().GetName()+ ":" + mustang.GetBrand().GetNation());

            Brand honda = coreApplicationContext.getBean("Honda", Brand.class);
            System.out.println(honda.GetName() + ":" + honda.GetNation());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}
