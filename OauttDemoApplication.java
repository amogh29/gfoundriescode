package com.gfndry.Oautt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableOAuth2Sso
public class OauttDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauttDemoApplication.class, args);
	}

}
