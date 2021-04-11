package com.chars.rabbitmq.study.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(
                value = "phone.topic.queue",durable = "true",autoDelete = "false"
        ),
        exchange = @Exchange(
                value = "topic_order_exchange",type = ExchangeTypes.TOPIC
        ),
        key = "*.phone.#"
))
public class TopicPhoneConsumer {

    @RabbitHandler
    public void reciveMessage(String message) {
        System.out.println("phone --->  ");
        System.out.println("phone recived message (  by topic  ) ---> " + message);
    }
}
