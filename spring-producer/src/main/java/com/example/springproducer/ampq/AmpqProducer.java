package com.example.springproducer.ampq;

public interface AmpqProducer<T> {

    void produce(T t);
}
