package com.excmmy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan(basePackages = "com.excmmy.mapper")
@EnableCaching // 开启 Cache 注解标记
@EnableDiscoveryClient
//@EnableCircuitBreaker // 开启 Hystrix
public class RunUsersServer {
    public static void main(String[] args) {
        SpringApplication.run(RunUsersServer.class);
    }
}
