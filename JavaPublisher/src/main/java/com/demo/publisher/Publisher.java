package com.demo.publisher;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Publisher {
    public static void main(String[] args) {
        //specify username, password, blockerURL
        ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");

        try {
            Connection connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            //provide the queue where we want to  publish the message, if queue doesn't exist it creates a new queue
            Destination destination = session.createQueue("demo");


            //create the producer to publish the message to queue
            MessageProducer producer = session.createProducer(destination);

            // create the message
            String[] messages={"first Message","second Message","third Message","forth Message"};
            for(String message:messages) {
                TextMessage textMessage = session.createTextMessage(message);
                //send message
                producer.send(textMessage);
            }



            System.out.println("message published");
            //close session and connection
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();

        }


    }
}
