package com.cbc.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SendTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /*
    直接将消息发送到队列
     */
    @Test
    void sendToQueue(){
        String queueName = "cbc.queue1";
        String msg = "Hello,mq1";
        for(int i = 0;i<50;i++){
            rabbitTemplate.convertAndSend(queueName,msg+i);
        }
    }
    /*
    Fanout 广播 会将接收到的消息广播到每一个队列 也叫广播模式
     */
    @Test
    void sendToFanout(){
        String exchangeName = "cbc.fanout";
        String msg = "Hello,exchange";
        for(int i = 0;i<50;i++){
            rabbitTemplate.convertAndSend(exchangeName,"",msg+i);
        }
    }
    /*
    Direct 会将接收到的消息根据规则路由到指定的queue，因此称为定向路由
     */
    @Test
    void sendToDirect(){
        String exchangeName = "cbc.exchanges";
        rabbitTemplate.convertAndSend(exchangeName,"red","hongse");
        rabbitTemplate.convertAndSend(exchangeName,"blue","lanse");
        rabbitTemplate.convertAndSend(exchangeName,"red","hong");

    }

}
