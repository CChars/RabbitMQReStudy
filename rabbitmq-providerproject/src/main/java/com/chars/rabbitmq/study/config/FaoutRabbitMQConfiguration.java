package com.chars.rabbitmq.study.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FaoutRabbitMQConfiguration {

    //1、声明交换机（这里是为fanout的交换机）
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout_order_exchange", true, false);
    }

    //2、声明队列
    @Bean
    public Queue fanout_smsQueue() {
        return new Queue("sms.fanout.queue", true);
    }

    @Bean
    public Queue fanout_phoneQueue() {
        return new Queue("phone.fanout.queue", true);
    }

    @Bean
    public Queue fanout_emailQueue() {
        return new Queue("email.fanout.queue", true);
    }

    //3、完成绑定关系
    @Bean
    public Binding fanout_smsBinging() {
        return BindingBuilder.bind(fanout_smsQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding fanout_phoneBinging() {
        return BindingBuilder.bind(fanout_phoneQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding fanout_emailBinging() {
        return BindingBuilder.bind(fanout_emailQueue()).to(fanoutExchange());
    }

}
