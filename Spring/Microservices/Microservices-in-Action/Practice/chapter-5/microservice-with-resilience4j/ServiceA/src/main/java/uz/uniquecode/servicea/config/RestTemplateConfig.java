package uz.uniquecode.servicea.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Author: Abbos Fayziboev
 * Date: 11/04/23
 * Email: abbosFayziboev@gmail.com
 */
@Configuration
public class RestTemplateConfig {


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
