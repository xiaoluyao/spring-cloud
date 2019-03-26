package com.forezp.serverribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@RestController
public class HelloContorller {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hi/{id}")
    public String hi(@PathVariable("id") String id){
        return helloService.hiService2(id);
    }

    public static void main(String[] args) throws Exception{
        User u=new User();
        //方式1:
        Class c1=User.class;
//方式2:
        Class c2=u.getClass();
//方式3:
        Class c3=Class.forName("com.forezp.serverribbon.User");

//可以通过类的类型创建该类的实例对象
        User user=(User)c1.newInstance();
        System.out.println(c1.getName());
        System.out.println(c2.getSimpleName());

        /**
         * 一个成员方法就是一个method对象
         * getMethod()所有的 public方法，包括父类继承的 public
         * getDeclaredMethods()获取该类所有的方法，包括private ,但不包括继承的方法。
         */
        Method[] methods=c1.getMethods();//获取方法

        //获取所以的方法，包括private ,c.getDeclaredMethods();

    }
}
