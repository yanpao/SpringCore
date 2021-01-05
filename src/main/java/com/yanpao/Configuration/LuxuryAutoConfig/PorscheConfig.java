package com.yanpao.Configuration.LuxuryAutoConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


/**
 * 测试以下接口或者方式：
 * <ul>
 *     <li>测试Java-Centric配置方式</li>
 *     <li>@ImportResource</li>
 * </ul>
 *
 * <p>
 *     Spring有两种配置方式，两种方式都可以用，没有优劣之分：
 * <ul>
 *     <li>XML-centric，使用ClassPathXmlApplicationContext和xml为主文件进行配置，如果在其中需要
 *     使用javaConfig,编写@Configuration,在xml文件将@Configuration作为一个普通Bean进行声明，比如
 *     <bean class="com.acme.AppConfig"/>，即可将@Configuration中配置的Bean注册，不需要为这个Bean
 *     指定id；或者使用扫描包的方式，比如<context:component-scan base-package="com.acme"/>扫描@Configuration、@Component等
 *     配置文件所在的包</li>
 *     <li>Java-centric，使用AnnotationConfigApplicationContext和@Configuration为主进行配置，如果需要使用
 *     xml中定义的Bean，使用@ImportResource引入xml即可。
 * </ul>
 * </p>
 */
@Configuration
@ImportResource("classpath:/Porsche.xml")
public class PorscheConfig {


}
