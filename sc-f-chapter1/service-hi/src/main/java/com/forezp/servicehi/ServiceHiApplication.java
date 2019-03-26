package com.forezp.servicehi;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}
	@Value("${server.port}")
	String port;

	@RequestMapping("/hi/{id}")
	public String home(@PathVariable("id") String id) {
		return "hi " + id + " ,i am from port:" + port;
	}

	@HystrixCommand(fallbackMethod = "hiError")
	public String home2(String name){
		 return "hi " + name + " ,i am from port:" + port;
	}

	public String hiError(String name) {
		return "hi,"+name+",sorry,error!";
	}
}
