package com.chars.rabbitmq.study.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"phone.direct.queue"})
@Component
public class DirectPhoneConsumer {

    @RabbitHandler
    public void reciveMessage(String message) {
        System.out.println("phone --->  ");
        System.out.println("phone recived message (  by direct  ) ---> " + message);
    }
}
