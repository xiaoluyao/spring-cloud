package com.forezp.serverfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-hi")
public interface SchechelSV {
    @RequestMapping(value ="/hi/{name}")
    public String SayHifromClient(@PathVariable("name")String name);
}
