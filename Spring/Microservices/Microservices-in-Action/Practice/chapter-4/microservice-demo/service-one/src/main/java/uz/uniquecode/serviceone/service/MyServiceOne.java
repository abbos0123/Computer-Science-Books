package uz.uniquecode.serviceone.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.uniquecode.serviceone.model.Message;

@Service
public class MyServiceOne {

    private final RestTemplate restTemplate;

    public MyServiceOne(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Message getMessageFromRemoteServer(){
      return restTemplate.getForObject("http://SERVICE-TWO/v1/api/message", Message.class);
    }
}
