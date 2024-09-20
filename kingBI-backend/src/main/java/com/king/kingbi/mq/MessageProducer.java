package com.king.kingbi.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * ClassName:MessageProducer
 * Description:
 *
 * @Author:kinglearn
 * @Create2024/9/17 15:47
 * @version1.0
 */
@Component
@Slf4j
public class MessageProducer {
    @Resource
    private RabbitTemplate rabbitTemplate;
    public void sendMessage(String exchange,String routingKey,String message){
        log.info("Sending message: {} to exchange: {}, routingKey: {}", message, exchange, routingKey);
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
    }
}
