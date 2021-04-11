package com.chars.rabbitmq.study.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import javax.lang.model.type.ExecutableType;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(
                value = "email.topic.queue",durable = "true",autoDelete = "false"
        ),
        exchange = @Exchange(
                value = "topic_order_exchange",type = ExchangeTypes.TOPIC
        ),
        key = "#.email.#"
))
public class TopicEmailConsumer {

    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("email--->  ");
        System.out.println("email message is (  by topic  ) --->  " + message);
    }
}
