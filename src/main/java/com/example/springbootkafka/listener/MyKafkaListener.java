package com.example.springbootkafka.listener;

import com.example.springbootkafka.model.Employee;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaListener {

    //listening for topic "news" which receives news string
    @KafkaListener(topics = "news")
    public void consume(String msg){
        System.out.println("got msg from listener: " + msg);
    }

    //listening for topic "employee" which receives employee object
    @KafkaListener(topics = "employee", groupId = "group2", containerFactory = "employeeKafkaListenerContainerFactory")
    public void consumeEmployee(Employee employee){
        System.out.println("This is Kafka listener for employee: " + employee);
    }
}
