package com.example.demo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class Consumer {
    @JmsListener(destination =  "primacoada.queue")
    public void consume(final String message)throws JMSException {
        System.out.println("Received Message: " + message);
    }
}
