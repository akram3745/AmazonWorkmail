package com.workemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsWorkEmailDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsWorkEmailDemoApplication.class, args);

	}
	
//	@Bean
//	public JavaMailSender getmail() {
//		return new JavaMailSenderImpl();
//	}

}
