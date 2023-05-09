package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageCreateSender
{

    //Injecting JMSTemplate
    @Autowired
    private JmsTemplate jmsTemplate;

    //We are dynamically injecting a queue name.
    @Value("${springjms.myQueue}")
    private String queue;

    //To manually covert the message, convert the messages using MessageCreator
    public void sendMessage2()
    {

        MessageCreator mc = s-> s.createTextMessage("MessageCreator");

        System.out.println("Message Sent ---->  "+mc);
        //By default this send method sends message to topic, to make it send to queue.
        //You need to make the value of spring.jms.pub-sub-domain=true
        //or
        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.send(queue,mc);

        }



}
