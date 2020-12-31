package com.yanpao;

import com.yanpao.Cars.Automobile;
import com.yanpao.Cars.Brand;
import com.yanpao.Configuration.AutomobileConfig.Mustang;
import com.yanpao.Configuration.AutomobileConfig.ToyotaConfig;
import com.yanpao.Configuration.BrandConfig.AmericanBrandConfig;
import com.yanpao.Configuration.BrandConfig.GermanicBrandConfig;
import com.yanpao.Configuration.BrandConfig.JapaneseBrandConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreApp
{
    public static void main( String[] args )
    {
        /*初始化Spring容器的几种不同方式
        方式1:构造函数初始化，将@Configuration的类作为参数传入，可以传入多个参数，@Component or JSR-330 annotated class也可
        但是，如果使用有参构造函数，就无法使用refresh()（只能refresh一次），后续的register、scan等方式也就无效（不refresh就无法注册进去）*/
        AnnotationConfigApplicationContext coreApplicationContext
                = new AnnotationConfigApplicationContext();
        /*方式2：注册，直接注册所有要用的@Configuration类*/
        coreApplicationContext.register(GermanicBrandConfig.class, AmericanBrandConfig.class,JapaneseBrandConfig.class);

        /*方式3：注册，可以注册@Component类和@Configuration类
        * 注意：前面并未注册ToyotaConfig的依赖类JapaneseBrandConfig，在ToyotaConfig中使用@Import引入了JapaneseBrandConfig，
        * Spring会将JapaneseBrandConfig注册进入容器*/
        coreApplicationContext.register(Mustang.class,ToyotaConfig.class);

        /*方式4：扫描，扫描指定的包*/
        coreApplicationContext.scan("com.yanpao.Configuration.LuxuryAutoConfig");

        /*必须要刷新，否则不会起效*/
        coreApplicationContext.refresh();

        try {
            Brand toyota = coreApplicationContext.getBean("Toyota1", Brand.class);
            System.out.println(toyota.GetName() + ":" + toyota.GetNation());

            Mustang mustang = coreApplicationContext.getBean("mustang", Mustang.class);
            System.out.println(mustang.GetName()+ ":" + mustang.GetCost()
                    + ":" + mustang.GetBrand().GetName()+ ":" + mustang.GetBrand().GetNation());

            Automobile Yaris = coreApplicationContext.getBean("Yaris", Automobile.class);
            System.out.println(Yaris.GetName()+ ":" + Yaris.GetCost()
                    + ":" + Yaris.GetBrand().GetName()+ ":" + Yaris.GetBrand().GetNation());

            Automobile Levin = coreApplicationContext.getBean("Levin", Automobile.class);
            System.out.println(Levin.GetName()+ ":" + Levin.GetCost()
                    + ":" + Levin.GetBrand().GetName()+ ":" + Levin.GetBrand().GetNation());

            Automobile Corolla = coreApplicationContext.getBean("Corolla", Automobile.class);
            System.out.println(Corolla.GetName()+ ":" + Corolla.GetCost()
                    + ":" + Corolla.GetBrand().GetName()+ ":"  + Corolla.GetBrand().GetNation());

            Automobile A4 = coreApplicationContext.getBean("A4", Automobile.class);
            System.out.println(A4.GetName()+ ":" + A4.GetCost()
                    + ":" + A4.GetBrand().GetName()+ ":" + A4.GetBrand().GetNation());

            Brand honda = coreApplicationContext.getBean("Honda", Brand.class);
            System.out.println(honda.GetName() + ":" + honda.GetNation());

            System.out.println("-------------------------------------------------------");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}
