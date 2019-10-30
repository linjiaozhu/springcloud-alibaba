package com.zcl.consumer.controller;


import com.zcl.consumer.service.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    public TestController(RestTemplate restTemplate) {this.restTemplate = restTemplate;}

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return restTemplate.getForObject("http://provider/echo/" + str, String.class);
    }


    @GetMapping("/hi-feign")
    public String hiFeign(){
        return restTemplate.getForObject("http://provider/hi3" + "feign", String.class);
    }


    @Autowired
    ProviderClient providerClient;

    @GetMapping("/hi-feign2")
    public String hiFeign2(){
        return providerClient.hi("feign");
    }
}
