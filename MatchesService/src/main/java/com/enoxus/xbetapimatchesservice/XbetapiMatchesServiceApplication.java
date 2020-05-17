package com.enoxus.xbetapimatchesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@SpringBootApplication
@EnableDiscoveryClient
public class XbetapiMatchesServiceApplication {
    @Bean
    public DecimalFormat decimalFormat() {
        DecimalFormat df = new DecimalFormat("#.###", new DecimalFormatSymbols(Locale.US));
        df.setRoundingMode(RoundingMode.FLOOR);

        return df;
    }

    public static void main(String[] args) {
        SpringApplication.run(XbetapiMatchesServiceApplication.class, args);
    }

}
