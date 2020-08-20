package com.example.springproducer.api;

import com.example.springproducer.dto.MessageDTO;
import com.example.springproducer.service.AmpqService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AmpqApi {

    private AmpqService service;

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendToConsumer(@RequestBody MessageDTO message){
        service.sendToConsumer(message);
    }
}
