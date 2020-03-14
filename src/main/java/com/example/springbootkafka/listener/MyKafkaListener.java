package com.example.springbootkafka.listener;

import com.example.springbootkafka.model.Employee;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaListener {

    @KafkaListener(topics = "news")
    public void consume(String msg){
        System.out.println("got msg from listener: " + msg);
    }

    @KafkaListener(topics = "employee", groupId = "group2", containerFactory = "employeeKafkaListenerContainerFactory")
    public void consumeEmployee(Employee employee){
        System.out.println("This is Kafka listener for employee: " + employee);
    }
}
