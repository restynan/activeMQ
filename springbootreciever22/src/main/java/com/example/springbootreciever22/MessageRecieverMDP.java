package com.example.springbootreciever22;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageRecieverMDP {
    @JmsListener(destination = "positionQueue")
    public void processMessage(String message){
        //long processing
        System.out.print("attempting to process the message");
        //middle oppps  there is a crash eg a data center just lost its power
        // message willnot be lost ,it will be requeued
        // if the a message is requeued morethan a certain threshold , the blocker send the message to a DLQ

      /*if(0==0) {
           System.out.println("crashed");
           throw  new RuntimeException("reployement stoped");}

*/


        //end result
        System.out.println(message);

    }
}
