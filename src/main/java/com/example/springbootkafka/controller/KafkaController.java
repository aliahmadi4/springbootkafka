package com.example.springbootkafka.controller;

import com.example.springbootkafka.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("kafka")
public class KafkaController {
    
    @Autowired
    private KafkaTemplate<String, String> stringKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Employee> employeeKafkaTemplate;

    //new String will be sent to "news" topic
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String sendMsg(@RequestParam("message") String msg){
        stringKafkaTemplate.send("news", msg);
//        System.out.println("message received " + msg);
        return "redirect:/";
    }

    //new employee object will be sent to "employee" topic
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String sendEmployee(@RequestParam("name") String name, @RequestParam("age") String age){
        Employee employee = new Employee(name, age);

        employeeKafkaTemplate.send("employee", employee);
//        System.out.println("message received " + employee);
        return "redirect:/";
    }

    //just to show first page
    @RequestMapping("/")
    public String showHomepage(){
        return "index";
    }




}
