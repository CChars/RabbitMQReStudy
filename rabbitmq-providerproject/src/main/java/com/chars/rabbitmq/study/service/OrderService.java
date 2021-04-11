package com.chars.rabbitmq.study.service;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 *
 */
@Component
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void makeOrder(String userid, String productid, int num) {
        String orderID = UUID.randomUUID().toString();
        System.out.println("----order:" + orderID + " is generated----");
        //通过MQ来完成消息的发送
        String exchangeName = "fanout_order_exchange";
        String routingKey = "";
        //参数一是交换机的名称，参数二是路由key ，参数三这里是消息内容
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderID);
    }

    public void makeOrderByDirect(String userid, String productid, int num) {
        String orderID = UUID.randomUUID().toString();
        System.out.println("------------------------------------------");
        System.out.println("----order:" + orderID + " is generated----");
        System.out.println("------------------------------------------");
        //通过MQ来完成消息的发送
        String exchangeName = "direct_order_exchange";
        String routingKey = "";
        //参数一是交换机的名称，参数二是路由key ，参数三这里是消息内容
        rabbitTemplate.convertAndSend(exchangeName, "email", orderID);
        rabbitTemplate.convertAndSend(exchangeName, "sms", orderID);
        rabbitTemplate.convertAndSend(exchangeName, "phone", orderID);
    }

    public void makeOrderByTopic(String userid, String productid, int num) {
        String orderID = UUID.randomUUID().toString();
        System.out.println("------------------------------------------");
        System.out.println("----order:" + orderID + " is generated----");
        System.out.println("------------------------------------------");
        //通过MQ来完成消息的发送
        String exchangeName = "topic_order_exchange";
        String routingKey = "com.aaa.email.bbb";
        //参数一是交换机的名称，参数二是路由key ，参数三这里是消息内容
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderID);
    }


    public void makeOrderByTTL_Direct(String userid, String productid, int num) {
        String orderID = UUID.randomUUID().toString();
        System.out.println("------------------------------------------");
        System.out.println("----order:" + orderID + " is generated----");
        System.out.println("------------------------------------------");
        //通过MQ来完成消息的发送
        String exchangeName = "TTL_direct_exchange";
        String routingKey = "";

        //单独设置过期时间
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration("3000");
                message.getMessageProperties().setContentEncoding("UFT-8");
                return message;
            }
        };
        //参数一是交换机的名称，参数二是路由key ，参数三这里是消息内容
        rabbitTemplate.convertAndSend(exchangeName, "TTL_SMS", orderID,messagePostProcessor);
    }
}
