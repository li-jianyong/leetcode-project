package com.springbatch.demo.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
    private String name;
    private int age;
    private String id;
    private String password;
    private String username;
    public User(String name) {
        this.name = name;
    }
//    public User(){}
    public String toString(){
        return this.name + " --- " + this.age;
    }
    public int increaseAge(int count) {
        age += count;
        return age;
    }
}
