package com.zcl.provider.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.*;

@RestController
public class EchoController {

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

    @GetMapping("/hi")
    @SentinelResource(value="hi")
    public String hi(@RequestParam(value = "name",defaultValue = "forezp",required = false)String name){

        return "hi "+name;
    }
    @GetMapping("/hi3")
    public String hi3(@RequestParam(value = "name",defaultValue = "forezp",required = false)String name){

        return "hi "+name;
    }


}
