package com.bridgelabz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@Slf4j
public class PayrollWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollWebAppApplication.class, args);
	}

}
