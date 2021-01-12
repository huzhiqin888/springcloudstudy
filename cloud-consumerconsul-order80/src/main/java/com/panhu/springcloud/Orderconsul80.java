package com.panhu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Orderconsul80 {
     public static void main(String[] args) {
         SpringApplication.run(Orderconsul80.class,args);
      }
}
