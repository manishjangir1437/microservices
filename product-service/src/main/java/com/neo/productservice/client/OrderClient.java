package com.neo.productservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ORDER-SERVICE")
public interface OrderClient {

    @GetMapping(value = "/home")
    String getHome();
}
