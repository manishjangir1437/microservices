package com.neo.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.keyStore", "order-service/src/main/resources/order.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "123456");
        System.setProperty("javax.net.ssl.trustStore", "order-service/src/main/resources/order.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "123456");
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
