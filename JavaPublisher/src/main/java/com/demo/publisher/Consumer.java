package com.demo.publisher;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {
    public static void main(String[] args) {
        //create object of Connection factory specify username, password, blockerURL
        ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");

        try {
            Connection connection = factory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

            //provide the queue where we want to  get the message
            Destination destination = session.createQueue("demo");

            //create the consumer to consume the message from queue
            MessageConsumer consumer = session.createConsumer(destination);

              // the consumer has to continuously listen to the queue and every message the consumer gets goes to the on message
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                 //cast the recieved message to Textmessage
                    TextMessage textMessage= (TextMessage) message;
                    try {
                        System.out.println(textMessage.getText());
                        textMessage.acknowledge();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });




        } catch (JMSException e) {
            e.printStackTrace();

        }
    }
}
