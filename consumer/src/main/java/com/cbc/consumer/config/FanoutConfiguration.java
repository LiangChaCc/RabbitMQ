package com.cbc.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FanoutConfiguration {

    /*
    创建fanout交换机
     */
    @Bean
    public FanoutExchange fanoutExchange(){
//        两种方法创建交换机
//        ExchangeBuilder.fanoutExchange("cbc.fanout2");
        return new FanoutExchange("cbc.fanout2");
    }
    /*
    创建队列
     */
    @Bean
    public Queue queue(){
//        QueueBuilder.durable();//当前队列是一个持久化队列
        return new Queue("cbc.queue");
    }
    /*
    绑定交换机和队列
     */
    @Bean
    public Binding binding(Queue queue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    /*
    创建direct交换机
     */
    @Bean
    public DirectExchange directExchange(){
//        两种方法创建交换机
//        ExchangeBuilder.fanoutExchange("cbc.direct2");
        return new DirectExchange("cbc.direct2");
    }
    /*
    创建队列
     */
    @Bean
    public Queue directQueue(){
//        QueueBuilder.durable();//当前队列是一个持久化队列
        return new Queue("cbc.directQueue");
    }
    /*
    绑定交换机和队列
     */
    @Bean
    public Binding bindingDirect1(Queue directQueue,DirectExchange directExchange){
        return BindingBuilder.bind(directQueue).to(directExchange).with("red");
    }
    /*
    绑定交换机和队列
     */
    @Bean
    public Binding bindingDirect2(Queue directQueue,DirectExchange directExchange){
        return BindingBuilder.bind(directQueue).to(directExchange).with("blue");
    }



}
