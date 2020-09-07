package com.example.springjmsconsumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    @JmsListener(destination = "demo")
    public void  recieveMessage(String message){
      System.out.println(message);

    }



}
