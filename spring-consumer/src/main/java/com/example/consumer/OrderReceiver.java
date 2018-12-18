package com.example.consumer;

import com.example.entity.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @Auther: ljh
 * @Date: 2018/9/28 15:01
 * @Description:
 */
@Component
public class OrderReceiver {

    @RabbitListener( bindings =@QueueBinding(
            value = @Queue(value = "order-queue",durable = "true"),
            exchange =@Exchange(value = "order-exchange",type = "topic"),
            key = "order.*")
    )
    @RabbitHandler
    public void OrderMessage(@Payload Order order, @Headers Map<String,Object> headers, Channel channel) throws IOException {
        System.out.println("收到消息------");
        System.out.println("订单Id"+order.getId()+",订单名称"+order.getName()+"，消息id"+order.getMessageId());

        Long deliverTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliverTag,false);
    }
}
