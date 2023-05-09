package com;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listner
{
    @JmsListener(destination = "${springjms.myQueue}")
    public void receive(String message)
    {
        System.out.println("Message received ---->  "+message);
    }

}
