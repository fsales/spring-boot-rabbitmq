package com.example.spring.consumer.service.implementation;

import com.example.spring.consumer.dto.MessageDTO;
import com.example.spring.consumer.service.ConsumerService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public void action(MessageDTO message) throws  Exception {
      //  throw  new Exception("Erro >>>>>>>>>>>");
        System.out.println(message.getText());
    }
}
