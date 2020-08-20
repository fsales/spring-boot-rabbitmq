package com.example.springproducer.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerRabbitConfiguration {

    private String queue;
    private String exchange;
    private String deadLetter;

    public ProducerRabbitConfiguration(@Value("${spring.rabbitmq.request.routing-key.producer}") String queue,
                                       @Value("${spring.rabbitmq.request.exchange.producer}") String exchange,
                                       @Value("${spring.rabbitmq.request.deadletter.producer}") String deadLetter){
        this.queue = queue;
        this.exchange = exchange;
        this.deadLetter = deadLetter;
    }

    @Bean
    DirectExchange exchange(){

        return  new DirectExchange(exchange);
    }

    @Bean
    Queue deadLetter(){
        return  new Queue(deadLetter);
    }

    @Bean
    Queue queue(){
        Map<String, Object> arg = new HashMap<>();
        arg.put("x-dead-letter-exchange", exchange);
        arg.put("x-dead-letter-routing-key", deadLetter);
        return new Queue(queue, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, arg);
    }

    @Bean
    public Binding bindingQueue(){

        return BindingBuilder.bind(queue()).to(exchange()).with(queue);
    }

    @Bean
    public Binding bindingDeadLetter(){

        return BindingBuilder.bind(deadLetter()).to(exchange()).with(deadLetter);
    }

}
