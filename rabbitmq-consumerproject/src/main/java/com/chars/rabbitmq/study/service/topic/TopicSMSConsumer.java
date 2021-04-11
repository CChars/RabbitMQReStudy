package com.chars.rabbitmq.study.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
//通过注解的方式来配置 topic 模式的队列
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(
                value = "sms.topic.queue",durable = "true",autoDelete = "false"
        ),
        exchange = @Exchange(
                value = "topic_order_exchange",type = ExchangeTypes.TOPIC
        ),
        key = "com.#"
))
public class TopicSMSConsumer {
    @RabbitHandler
    public void reciveMessage(String message) {
        System.out.println("sms --->  ");
        System.out.println("sms recived message (  by topic  ) ---> " + message);
    }
}
