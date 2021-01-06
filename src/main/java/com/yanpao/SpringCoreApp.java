package com.yanpao;

import com.yanpao.Cars.Brand;
import com.yanpao.Cars.Vehicle;
import com.yanpao.Configuration.AutomobileConfig.*;
import com.yanpao.Configuration.BrandConfig.AmericanBrandConfig;
import com.yanpao.Configuration.BrandConfig.GermanicBrandConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

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
        coreApplicationContext.register(GermanicBrandConfig.class, AmericanBrandConfig.class);

        /*方式3：注册，可以注册@Component类和@Configuration类
        * 注意：前面并未注册ToyotaConfig的依赖类JapaneseBrandConfig，在ToyotaConfig中使用@Import引入了JapaneseBrandConfig，
        * Spring会将JapaneseBrandConfig注册进入容器*/
        coreApplicationContext.register(Mustang.class, Aventador.class,ToyotaConfig.class, HondaConfig.class, AutowireConfig.class);

        /*方式4：扫描，扫描指定的包*/
        coreApplicationContext.scan("com.yanpao.Configuration.LuxuryAutoConfig");

        /*必须要刷新，否则不会起效*/
        coreApplicationContext.refresh();

        System.out.println("扫描和注册完成，开始输出");

        try {

            /*根据某个类或者某个接口获取容器中所有的该类的Bean*/
            Map<String,Brand> allBrands = coreApplicationContext.getBeansOfType(Brand.class);
            for (Brand brand: allBrands.values())
            {
                System.out.println(brand.getName() + ":" + brand.getNation()+":"+brand.getBeanName());
            }

            Map<String, Vehicle> allVehicles = coreApplicationContext.getBeansOfType(Vehicle.class);
            for (Vehicle vehicle: allVehicles.values())
            {
                System.out.println(vehicle.getName()+ ":" + vehicle.getCost()
                        + ":" + vehicle.getBrand().getName()+ ":" + vehicle.getBrand().getNation());
            }

            System.out.println("-------------------------------------------------------");

            Mustang mustang = coreApplicationContext.getBean("mustang",Mustang.class);
            System.out.println(mustang.getName()+ ":" + mustang.getCost()
                    + ":" + mustang.getBrand().getName()+ ":" + mustang.getBrand().getNation());

            /*容器注册@Configuration的时候，注册的名称是类名的驼峰小写，注册@Bean的时候是函数名*/
            System.out.println("----------------测试自动注入的List-------------------");
            AutowireConfig autowireConfig = coreApplicationContext.getBean("autowireConfig", AutowireConfig.class);
            autowireConfig.autowireList();
            autowireConfig.autowireBrand();

            System.out.println("----------------测试lite @Bean mode,返回不一样-------------------");
            HondaConfig hondaConfig = coreApplicationContext.getBean("hondaConfig",HondaConfig.class);
            hondaConfig.test();
            hondaConfig.test();

            System.out.println("----------------测试Full Configuration mode，返回一致-------------------");
            ToyotaConfig toyotaConfig = coreApplicationContext.getBean("toyotaConfig",ToyotaConfig.class);
            toyotaConfig.test();
            toyotaConfig.test();

            System.out.println("----------------找不到未注册的Bean-------------------");
            /*未扫描或者注册，所以找不到这个Bean*/
            ModelX modelX = coreApplicationContext.getBean("modelX",ModelX.class);
            System.out.println(modelX.getName()+ ":" + modelX.getCost()
                    + ":" + modelX.getBrand().getName()+ ":" + modelX.getBrand().getNation());


        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally {
            coreApplicationContext.close();
        }

    }
}
