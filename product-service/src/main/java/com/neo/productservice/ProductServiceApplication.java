package com.neo.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
public class ProductServiceApplication {

    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.keyStore", "product-service/src/main/resources/product.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "123456");
        System.setProperty("javax.net.ssl.trustStore", "product-service/src/main/resources/product.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "123456");
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}
