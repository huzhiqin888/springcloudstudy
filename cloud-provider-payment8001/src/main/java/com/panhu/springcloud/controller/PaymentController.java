package com.panhu.springcloud.controller;



//import com.netflix.discovery.DiscoveryClient;
import com.panhu.springcloud.service.Paymentservice;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.panhu.springcloud.entities.CommonResult;

import com.panhu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private Paymentservice paymentservice;
    @Value("${server.port}")
    private String serverport;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/creat")
    public CommonResult creat(@RequestBody Payment payment) {
        int result = paymentservice.creat(payment);

        if (result > 0) {
            return new CommonResult(200, "插入成功,serverport: " + serverport, result);
        } else {
            return new CommonResult(444, "插入失败", result);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentbyId(@PathVariable("id") Long id) {
        Payment payment = paymentservice.getPaymentbyId(id);
        log.info("*****插入的结果是" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,serverport: " + serverport, payment);
        } else {
            return new CommonResult(444, "查询失败", null);

        }
    }

    @GetMapping("/customer/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*****service: " + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : instances) {
            log.info(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost()
                    + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb/{id}")
    public String getGateWayTest2(@PathVariable("id") Integer id){
        return "---8001 lb方法受到请求，参数id为：" + id;
    }

}
