package com.hh.mirishop.orderpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@FeignClient
@EnableJpaAuditing
public class OrderpaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderpaymentApplication.class, args);
	}

}
