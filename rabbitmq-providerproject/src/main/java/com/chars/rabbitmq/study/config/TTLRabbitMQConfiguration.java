package com.chars.rabbitmq.study.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TTLRabbitMQConfiguration {

    //1、声明交换机（
    @Bean
    public DirectExchange TTL_DirectExchange() {
        return new DirectExchange("TTL_direct_exchange", true, false);
    }

    /**
     * 2、声明队列
     * 队列一旦创建 添加或修改参数 不会生效 会报错 需要手动删除队列
     * 但是一般会选择重新新建队列
     * @return
     */
    @Bean
    public Queue TTL_Direct_smsQueue() {
        //设置过期时间
        Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl",7000);//时间一定是int类型
        //设置队列容量
        args.put("x-max-length",5);
        //设置过期队列的存储位置（死信队列）
        args.put("x-dead-letter-exchange","dead_direct_exchange");//设置交换机
        args.put("x-dead-letter-routing-key","dead_test");//设置死信队列的路由（direct模式）
        return new Queue("TTL.direct.queue", true,false,false,args);
    }
    @Bean
    public Binding TTL_Direct_emailBinging() {
        return BindingBuilder.bind(TTL_Direct_smsQueue()).to(TTL_DirectExchange()).with("TTL_SMS");
    }

}
