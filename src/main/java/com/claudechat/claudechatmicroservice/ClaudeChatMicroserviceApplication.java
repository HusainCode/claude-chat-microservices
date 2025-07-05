package com.claudechat.claudechatmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


// the main entry  point

@SpringBootApplication
public class ClaudeChatMicroserviceApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("ClaudeChatMicroserviceApplication");

        SpringApplication.run(ClaudeChatMicroserviceApplication.class, args);
    }

}


