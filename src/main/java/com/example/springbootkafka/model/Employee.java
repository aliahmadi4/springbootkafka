package com.example.springbootkafka.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Data
public class Employee {
    String name;
    String age;

    public Employee(){} //necessary for deserialization
    
    public Employee(String name, String age){
        this.name = name;
        this.age = age;
    }


}
