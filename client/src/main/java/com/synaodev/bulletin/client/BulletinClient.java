package com.synaodev.bulletin.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.synaodev.bulletin")
public class BulletinClient {
	public static void main(String[] args) {
		SpringApplication.run(BulletinClient.class, args);
	}
}
