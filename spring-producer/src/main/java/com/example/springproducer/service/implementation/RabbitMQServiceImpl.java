package com.example.springproducer.service.implementation;

import com.example.springproducer.ampq.AmpqProducer;
import com.example.springproducer.dto.MessageDTO;
import com.example.springproducer.service.AmpqService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RabbitMQServiceImpl implements AmpqService {

    private AmpqProducer<MessageDTO> ampqProducer;

    @Override
    public void sendToConsumer(MessageDTO messageDTO) {
        ampqProducer.produce(messageDTO);
    }
}
