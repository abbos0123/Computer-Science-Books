package uz.uniquecode.servicea.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Author: Abbos Fayziboev
 * Date: 11/04/23
 * Email: abbosFayziboev@gmail.com
 */
@RestController
@RequestMapping("/api/a")
public class ServiceAController {
    private final RestTemplate restTemplate;
    private final String BASE_URL = "http://SERVICE-B";
    private final String SERVICE_A = "service-a";

    public ServiceAController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    int count = 1;

    @GetMapping
    @CircuitBreaker(name = SERVICE_A, fallbackMethod = "serviceAFallback")
  //  @Retry(name = SERVICE_A)
    public String serviceA() {
        String url = BASE_URL + "/api/b";
        System.out.println("Retry method is " + count++ +" times ...");
        return restTemplate.getForObject(url, String.class);
    }

    public String serviceAFallback(Exception e){
        return "This is generated default value as Failure signal ...";
    }
}
