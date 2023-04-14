package com.neo.orderservice.controller;

import com.neo.orderservice.client.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final ProductClient productClient;

    @RequestMapping(value = "/order-product")
    public String getProduct() {
        return productClient.getHome();
    }

    @RequestMapping(value = "/home")
    public String home() {
        return "Response from order-service";
    }
}
