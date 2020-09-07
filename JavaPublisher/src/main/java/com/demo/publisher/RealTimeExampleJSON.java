package com.demo.publisher;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.json.JSONObject;

import javax.jms.*;

public class RealTimeExampleJSON {
    public static void main(String[] args) {
        ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        try {
            Connection connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("demo");


            // create JSON message

            JSONObject json = new JSONObject();
            json.put("from_date", "01-Jan-2019");
            json.put("To_date", "31-DEc-2019");
            json.put("email", "xyz@gmail.com");
            json.put("query", "select * from query");
            TextMessage textMessage = session.createTextMessage(json.toString());

            MessageProducer producer = session.createProducer(destination);
            producer.send(textMessage);

            System.out.println("message published");

            //close session and connection
            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();

        }

    }
}
