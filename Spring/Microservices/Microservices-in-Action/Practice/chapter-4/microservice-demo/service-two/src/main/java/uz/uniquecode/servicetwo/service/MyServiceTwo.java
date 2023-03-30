package uz.uniquecode.servicetwo.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.uniquecode.servicetwo.model.Message;

@Service
public class MyServiceTwo {

    private final RestTemplate restTemplate;

    public MyServiceTwo(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Message getMessageFromRemoteServer(){
        return Message.builder()
                .name("Message-name")
                .sender("Server-two")
                .time("30.03.2023")
                .text("This is text of message ...")
                .build();
    }
}
