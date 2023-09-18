package com.example.callback_vk;

import com.example.callback_vk.dao.RandomIdDaoJdbc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class CallBackVkApplication {

    public static void main(String[] args) {
        System.out.println("Проект запустился");
        SpringApplication.run(CallBackVkApplication.class, args);
    }

}
