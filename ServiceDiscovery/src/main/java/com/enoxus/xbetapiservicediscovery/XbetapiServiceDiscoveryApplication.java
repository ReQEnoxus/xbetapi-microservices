package com.enoxus.xbetapiservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class XbetapiServiceDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(XbetapiServiceDiscoveryApplication.class, args);
    }

}
