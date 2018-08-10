package com.example.demo;

import com.example.demo.exception.MyException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling               //启用定时任务
@EnableAsync
public class SpringBootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);

//		try {
//			throw new MyException("111");
//		} catch (MyException e) {
//			e.printStackTrace();
//		}
	}
}
