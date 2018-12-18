package com.example.producer;

import com.example.entity.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: ljh
 * @Date: 2018/9/28 14:31
 * @Description:
 */
@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void senderOrder(Order order){
         CorrelationData correlationData= new CorrelationData();
        correlationData.setId(order.getId());
        rabbitTemplate.convertAndSend("order-exchange",//exchange
                "order.abcd", //routing-key
                order,//消息体
                correlationData // correlationData 消息的唯一 id
        );
    }

}
