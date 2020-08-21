package com.example.spring.consumer.ampq;

public interface AmpqConsumer<T> {

    void consumer(T t);
}
