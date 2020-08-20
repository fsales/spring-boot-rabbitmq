package com.example.springproducer.implementation;

import com.example.springproducer.ampq.AmpqProducer;
import com.example.springproducer.dto.MessageDTO;
import lombok.AllArgsConstructor;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerRabbitMQ implements AmpqProducer<MessageDTO> {

    private RabbitTemplate rabbitTemplate;

    private String exchange;

    private String queue;

    ProducerRabbitMQ(@Value("${spring.rabbitmq.request.routing-key.producer}") String queue,
                     @Value("${spring.rabbitmq.request.exchange.producer}") String exchange,
                     RabbitTemplate rabbitTemplate){
        this.queue = queue;
        this.exchange = exchange;
        this. rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void produce(MessageDTO messageDTO) {
        try{
            rabbitTemplate.convertAndSend(exchange, queue, messageDTO);
        }catch (Exception e){
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
