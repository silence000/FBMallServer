package com.excmmy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RunImagesServer {
    public static void main(String[] args) {
        SpringApplication.run(RunImagesServer.class);
    }
}
