package uz.uniquecode.servicea.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.uniquecode.servicea.model.Poet;
import uz.uniquecode.servicea.model.Response;
import uz.uniquecode.servicea.model.Tale;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Abbos Fayziboev
 * Date: 14/04/23
 * Email: abbosFayziboev@gmail.com
 */

@Service
@RequiredArgsConstructor
public class ServiceA {
    private final RestTemplate restTemplate;
    private final String CIRCUIT_BREAKER_NAME = "service-a";
    private final String URL_ALL_POETS="http://SERVICE-B/api/poet/all";
    private final String URL_SINGLE_POET="http://SERVICE-B/api/poet/";
    private final String URL_ALL_TALES="http://SERVICE-C/api/tale/all";
    private final String URL_SINGLE_TALE="http://SERVICE-C/api/tale/";
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "getAllPoetsDefault")
    public List<Poet> getAllPoets() {
        System.out.println(URL_ALL_POETS);
        List<Poet> list = new ArrayList<>();
        Response response = restTemplate.getForObject(URL_ALL_POETS, Response.class);
        if (response != null && !response.isError()) {
            List<Poet> myList = (List<Poet>) response.getData();
            list.addAll(myList);
        }
        return list;
    }

    public List<Poet> getAllPoetsDefault(Exception e) {
        List<Poet> list = new ArrayList<>();
        Poet poet = Poet.builder()
                .id(-1)
                .name("default-poet")
                .year(1998)
                .author("Not")
                .text("Default poet text ...")
                .build();
        list.add(poet);
        return list;
    }

    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "getAllTalesDefault")
    public List<Tale> getAllTales() {
        List<Tale> list = new ArrayList<>();
        Response response = restTemplate.getForObject(URL_ALL_TALES, Response.class);
        if (response != null && !response.isError()) {
            List<Tale> myList = (List<Tale>) response.getData();
            list.addAll(myList);
        }
        return list;
    }

    public List<Tale> getAllTalesDefault(Exception e) {
        List<Tale> list = new ArrayList<>();
        Tale tale = Tale.builder()
                .id(-1)
                .name("Default tale")
                .text("Default tale text")
                .author("Not available")
                .year(-1)
                .build();
        list.add(tale);
        return list;
    }

    public Object getTaleById(int id) {
        Response response = restTemplate
                .getForObject(URL_SINGLE_TALE + id, Response.class);
        if (response != null && !response.isError()) {

            return response.getData();
        }
        return null;
    }

    public Object getPoetById(int id) {
        Response response = restTemplate
                .getForObject(URL_SINGLE_POET + id, Response.class);
        if (response != null && !response.isError()) {
            return response.getData();
        }
        return null;
    }

}
