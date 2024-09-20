package com.king.kingbi.mq;

import com.rabbitmq.client.Channel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * ClassName:MessageConsumer
 * Description:
 *
 * @Author:kinglearn
 * @Create2024/9/17 15:48
 * @version1.0
 */
@Component
@Slf4j
public class MessageConsumer {
     //指定程序监听的队列
    @SneakyThrows
    @RabbitListener(queues = {"text_rabbit"},ackMode = "MANUAL")
     public void receiveMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag){
        log.info("receive message:{}",message);
        channel.basicAck(deliveryTag,false);
     }
}
