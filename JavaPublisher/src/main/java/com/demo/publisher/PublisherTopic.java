package com.demo.publisher;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class PublisherTopic {
    public static void main(String[] args) {

        ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");

        try {
            Connection connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic("Demo-Topic");
            MessageProducer producer = session.createProducer(destination);

            TextMessage textMessage = session.createTextMessage("message sent to Topic");
            producer.send(textMessage);


            System.out.println("message published to Topic");

            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();

        }


    }
}
