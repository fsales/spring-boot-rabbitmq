package com.example.spring.consumer.service;

import com.example.spring.consumer.dto.MessageDTO;

public interface ConsumerService {
    void action(MessageDTO messageDTO) throws  Exception;
}
