package com.ashu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicrotwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrotwoApplication.class, args);
	}

}
