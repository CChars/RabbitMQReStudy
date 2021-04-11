package com.chars.rabbitmq.study.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *死信队列的声明
 */
@Configuration
public class DeadRabbitMQConfiguration {
    @Bean
    public DirectExchange deadDirectExchange(){
        return new DirectExchange("dead_direct_exchange",true,false);
    }
    @Bean
    public Queue deadQueen(){
        return new Queue("dead_direct_queen",true);
    }
    @Bean
    public Binding DeadBinding(){
        return BindingBuilder.bind(deadQueen()).to(deadDirectExchange()).with("dead_test");
    }
}
