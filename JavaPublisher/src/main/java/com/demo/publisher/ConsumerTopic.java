package com.demo.publisher;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ConsumerTopic {
    public static void main(String[] args) {

        ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");

        try {
            Connection connection = factory.createConnection();
            connection.setClientID("1");
            connection.start();
            Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            Topic topic = session.createTopic("Demo-Topic");
            MessageConsumer consumer = session.createDurableSubscriber(topic,"Consumer-1");

            consumer.setMessageListener(message -> {

                TextMessage textMessage= (TextMessage) message;
                try {
                    System.out.println(textMessage.getText());
                    textMessage.acknowledge();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            });




        } catch (JMSException e) {
            e.printStackTrace();

        }
    }













}
