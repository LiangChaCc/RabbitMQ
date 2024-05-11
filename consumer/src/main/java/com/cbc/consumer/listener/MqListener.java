package com.cbc.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqListener {
//    @RabbitListener(queues = "cbc.queue1")
//    public void listenSimpleQueue(String msg){
//        System.out.println("1收到消息{"+msg+"}");
//    }
//    @RabbitListener(queues = "cbc.queue1")
//    public void listenSimpleQueue2(String msg){
//        System.out.println("2收到消息{"+msg+"}");
//    }

//    @RabbitListener(queues = "cbc.queue1")
//    public void listenSimpleQueue1(String msg){
//        System.out.println("1收到消息{"+msg+"}");
//    }
//    @RabbitListener(queues = "cbc.queue2")
//    public void listenSimpleQueue2(String msg){
//        System.out.println("2收到消息{"+msg+"}");
//    }
        @RabbitListener(bindings = @QueueBinding(
                value = @Queue(name = "cbc.queue3"),
                exchange = @Exchange(name = "cbc.exchange1",type = ExchangeTypes.DIRECT),
                key = {"red","yellow"}
        ))
    public void listenSimpleQueue2(String msg){
        System.out.println("2收到消息{"+msg+"}");
    }


}