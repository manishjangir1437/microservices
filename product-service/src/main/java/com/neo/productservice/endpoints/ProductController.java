package com.neo.productservice.endpoints;

import com.neo.productservice.client.OrderClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final OrderClient orderClient;

    @RequestMapping(value = "/product-order")
    public String getOrder() {
        return orderClient.getHome();
    }

    @RequestMapping(value = "/home")
    public String home() {
        return "Response from product-service";
    }
}
