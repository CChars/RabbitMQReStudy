package com.chars.rabbitmq.study.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"email.fanout.queue"})
@Component
public class FanoutEmailConsumer {
    @RabbitHandler
    public void reciveMessage(String message) {
        System.out.println("email--->  ");
        System.out.println("email recived message  (  by fanout  ) -> " + message);
    }
}
