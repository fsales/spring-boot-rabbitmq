package com.example.springproducer.service;

import com.example.springproducer.dto.MessageDTO;
import org.springframework.stereotype.Service;


public interface AmpqService {

    void sendToConsumer(MessageDTO messageDTO);
}
