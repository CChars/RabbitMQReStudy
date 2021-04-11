package com.chars.rabbitmq.study.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitMQConfiguration {

    //1、声明交换机（这里是为fanout的交换机）
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct_order_exchange", true, false);
    }

    //2、声明队列
    @Bean
    public Queue direct_smsQueue() {
        return new Queue("sms.direct.queue", true);
    }

    @Bean
    public Queue direct_phoneQueue() {
        return new Queue("phone.direct.queue", true);
    }

    @Bean
    public Queue direct_emailQueue() {
        return new Queue("email.direct.queue", true);
    }

    //3、完成绑定关系
    @Bean
    public Binding direct_smsBinging() {
        return BindingBuilder.bind(direct_smsQueue()).to(directExchange()).with("sms");
    }

    @Bean
    public Binding direct_phoneBinging() {
        return BindingBuilder.bind(direct_phoneQueue()).to(directExchange()).with("phone");
    }

    @Bean
    public Binding direct_emailBinging() {
        return BindingBuilder.bind(direct_emailQueue()).to(directExchange()).with("email");
    }

}
