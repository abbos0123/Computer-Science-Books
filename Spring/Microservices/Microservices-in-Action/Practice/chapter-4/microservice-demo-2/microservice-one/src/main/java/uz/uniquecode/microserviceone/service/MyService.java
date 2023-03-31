package uz.uniquecode.microserviceone.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * Author: Abbos Fayziboev
 * Date: 31/03/23
 * Email: abbosFayziboev@gmail.com
 */

@Service
public class MyService {
    @Value("${spring.application.name}")
    private String name;

    private final RestTemplate restTemplate;

    public MyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public HashMap<String, String> getAppData() {
        HashMap<String, String> result = new HashMap<>();
        result.put("application-one-name", name);

        HashMap<String, String> map = restTemplate.getForObject("http://MICROSERVICE-TWO/v1/api/get-app-name", HashMap.class);

        for (String key : map.keySet())
            result.put(key, map.get(key));

        map = restTemplate.getForObject("http://MICROSERVICE-THREE/v1/api/get-app-name", HashMap.class);

        for (String key : map.keySet())
            result.put(key, map.get(key));

        return result;
    }
}
