package com.panhu.springcloud;

import com.panhu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
//指定该负载均衡规则对哪个提供者服务使用    加载自定义规则的配置类
@RibbonClient(name="CLOUD-PROVIDER-PAYMENT", configuration = MySelfRule.class)
public class OrderMain80 {
      public static void main(String[] args) {
          SpringApplication.run(OrderMain80.class,args);
       }
}
