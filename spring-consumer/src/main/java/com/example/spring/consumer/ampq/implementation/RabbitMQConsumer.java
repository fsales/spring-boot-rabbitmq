package com.example.spring.consumer.ampq.implementation;

import com.example.spring.consumer.ampq.AmpqConsumer;
import com.example.spring.consumer.dto.MessageDTO;
import com.example.spring.consumer.service.ConsumerService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RabbitMQConsumer implements AmpqConsumer<MessageDTO> {

    private ConsumerService consumerService;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
    public void consumer(MessageDTO messageDTO){

        try{
            consumerService.action(messageDTO);
        }catch (Exception e){
            throw  new AmqpRejectAndDontRequeueException(e);
        }

    }
}
