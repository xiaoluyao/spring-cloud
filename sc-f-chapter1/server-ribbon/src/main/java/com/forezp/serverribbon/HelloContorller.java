package com.forezp.serverribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContorller {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hi/{id}")
    public String hi(@PathVariable("id") String id){
        return helloService.hiService2(id);
    }
}
