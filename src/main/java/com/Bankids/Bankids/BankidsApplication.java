package com.Bankids.Bankids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.Bankids.Controllers"})
@SpringBootApplication
public class BankidsApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankidsApplication.class, args);
	}

}
