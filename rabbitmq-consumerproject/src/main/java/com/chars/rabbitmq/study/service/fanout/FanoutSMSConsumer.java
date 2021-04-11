package com.chars.rabbitmq.study.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"sms.fanout.queue"})
@Component
public class FanoutSMSConsumer {
    @RabbitHandler
    public void reciveMessage(String message) {
        System.out.println("sms --->  ");
        System.out.println("sms recived message  (  by fanout  ) -> " + message);
    }
}
