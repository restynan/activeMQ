package com.example.springbootpublisher22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class Springbootpublisher22Application {

    public static void main(String[] args) {

        ApplicationContext ctx=SpringApplication.run(Springbootpublisher22Application.class, args);

        JmsTemplate jmsTemplate=ctx.getBean(JmsTemplate.class);
        jmsTemplate.convertAndSend("positionQueue","here is another Message");
    }

}
