package com.example.springbootreciever22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@SpringBootApplication
public class Springbootreciever22Application {

    public static void main(String[] args) throws JMSException {
        SpringApplication.run(Springbootreciever22Application.class, args);
       /* ApplicationContext ctx=SpringApplication.run(Springbootreciever22Application.class, args);
        JmsTemplate jmsTemplate=ctx.getBean(JmsTemplate.class);

        Message message=jmsTemplate.receive("positionQueue");
        TextMessage textMessage =(TextMessage)message;
        System.out.println(textMessage.getText());

        String  message = (String) jmsTemplate.receiveAndConvert("positionQueue");
        System.out.println(message);
*/
    }

}
