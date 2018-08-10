package com.example.demo;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootLogbackApplication {


	private static final Logger log = LoggerFactory.getLogger(SpringBootLogbackApplication.class);

	public static void start(){
		log.info("=========================服务启动 start ===============");
	}

	public static void main(String[] args){

//		SpringApplication springApplication = new SpringApplication();
//
//		springApplication.setBannerMode(Banner.Mode.LOG);
//
//		ConfigurableApplicationContext context = springApplication.run(SpringBootLogbackApplication.class,args);

		ConfigurableApplicationContext context = SpringApplication.run(SpringBootLogbackApplication.class, args);
		start();

		try {
			int i = 1/0;
		} catch (Exception e) {
			log.info(ExceptionUtils.getFullStackTrace(e));

			context.close();


		}
	}
}
