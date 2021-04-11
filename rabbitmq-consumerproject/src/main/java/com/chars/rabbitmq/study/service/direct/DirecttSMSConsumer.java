package com.chars.rabbitmq.study.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"sms.direct.queue"})
@Component
public class DirecttSMSConsumer {
    @RabbitHandler
    public void reciveMessage(String message) {
        System.out.println("sms --->  ");
        System.out.println("sms recived message (  by direct  ) ---> " + message);
    }
}
