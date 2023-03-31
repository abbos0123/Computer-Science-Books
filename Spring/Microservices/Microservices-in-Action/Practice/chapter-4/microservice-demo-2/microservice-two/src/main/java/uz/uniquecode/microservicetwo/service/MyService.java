package uz.uniquecode.microservicetwo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

    public HashMap<String, String> getAppData() {
        HashMap<String, String> result = new HashMap<>();
        result.put("application-two-name", name);
        return result;
    }
}
