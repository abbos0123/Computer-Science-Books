package uz.uniquecode.serviceb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Abbos Fayziboev
 * Date: 11/04/23
 * Email: abbosFayziboev@gmail.com
 */

@RestController
@RequestMapping("/api/b")
public class ServiceBController {

    @GetMapping
    public String serviceB(){
        return "The text is generated from service B as a successful text ...";
    }
}
