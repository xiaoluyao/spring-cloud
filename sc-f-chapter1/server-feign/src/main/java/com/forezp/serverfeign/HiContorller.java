package com.forezp.serverfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiContorller {
    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    SchechelSV schechelSV;

    @GetMapping(value = "/hi/{name}")
    public String sayHi(@PathVariable("name") String name) {
        return schechelSV.SayHifromClient( name );
    }

}
