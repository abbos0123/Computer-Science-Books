package uz.uniquecode.dicoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DicoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DicoveryServiceApplication.class, args);
    }

}
