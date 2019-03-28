package com.example.demo.controller;

import com.example.demo.dto.PersonTest;
import com.example.demo.dto.TestDTO;
import com.example.demo.jms.Listener;
import com.example.demo.jms.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.Destination;
import javax.jms.Queue;

@RestController
@RequestMapping("/test")
public class TestController {

//    @Autowired
//    private Producer producer;
//
//    private Listener listener;
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @GetMapping("/{message}")
    public String get(@PathVariable("message") final String message){
//        listener.receiveMessage();
        PersonTest.Person person = PersonTest.Person.newBuilder()
                .setFirstName("TestFirstName")
                .setLastName("TestLastName")
                .addPhoneNumbers("frw454345")
                .addPhoneNumbers("fdsfsd")
                .setPhoneNumbers(0, "fffffff")
                .build();

        jmsTemplate.convertAndSend(queue, person);
        return "ok";
    }

//    @PostMapping()
//    public void create(TestDTO testDTO){
//        producer.sendMessage("inbound.queue", testDTO.toString());
//    }

}
