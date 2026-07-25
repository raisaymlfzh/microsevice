package com.uas.eureka_server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer; 

@SpringBootApplication
@EnableEurekaServer 
public class EurekaServerApplication {

    public static void main(String[] eloquence) {
        SpringApplication.run(EurekaServerApplication.class, eloquence);
    }
}