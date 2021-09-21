package com.crypto.bankapi;

import com.crypto.bankapi.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class BankApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApiApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/api/login-management/logon").allowedOrigins("http://127.0.0.1:3000");
//			}
//		};
//	}

//	@Bean
//	CommandLineRunner run(AppUserService appUserService) {
//		return args -> {
//			//userService.saveRole(new BankRole(null, "ROLE_USER"));
//
//		};
//	}

}
