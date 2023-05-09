package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class Sender
{

    //Injecting JMSTemplate
    @Autowired
    private JmsTemplate jmsTemplate;

    //We are dynamically injecting a queue name.
    @Value("${springjms.myQueue}")
    private String queue;

    //convertAndSend Method converts Text to JMS Text
    //convertAndSend will convert the message to required format send it
    public void sendMessage(String message)
    {
        System.out.println("Message Sent ---->  "+message);
        jmsTemplate.convertAndSend(queue,message);
    }


}
