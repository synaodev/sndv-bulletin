package com.synaodev.bulletin.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.synaodev.bulletin")
public class BulletinApi {
	public static void main(String[] args) {
		SpringApplication.run(BulletinApi.class, args);
	}
}
