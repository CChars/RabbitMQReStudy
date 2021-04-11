package com.chars.rabbitmq.study.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"phone.fanout.queue"})
@Component
public class FanoutPhoneConsumer {

    @RabbitHandler
    public void reciveMessage(String message) {
        System.out.println("phone --->  ");
        System.out.println("phone recived message (  by fanout  ) -> " + message);
    }
}
