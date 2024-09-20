package com.king.kingbi.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * ClassName:MqInit
 * Description:
 *
 * @Author:kinglearn
 * @Create2024/9/17 16:07
 * @version1.0
 */
public class MqInit {
    public static void main(String[] args) {

        try {
            String EXCHANGE_NAME = "kingbi_exchange";
            String queueName = "text_rabbit";
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("localhost");
             Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            channel.queueDeclare(queueName,true,false,false,null);
            channel.queueBind(queueName,EXCHANGE_NAME,"text");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
