package com.excmmy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan(basePackages = "com.excmmy.mapper")
@EnableCaching // 开启 Cache 注解标记
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class RunOrdersServer {
    public static void main(String[] args) {
        SpringApplication.run(RunOrdersServer.class);
    }
}
