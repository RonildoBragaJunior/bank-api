package com.crypto.bankapi;

import com.crypto.bankapi.entity.ApiUser;
import com.crypto.bankapi.entity.ApiRole;
import com.crypto.bankapi.service.ApiUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class BankApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApiApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(ApiUserService apiUserService) {
		return args -> {
			apiUserService.saveRole(new ApiRole(null, "USER"));
			apiUserService.saveRole(new ApiRole(null, "MANAGER"));
			apiUserService.saveRole(new ApiRole(null, "ADMIN"));

			apiUserService.saveUser(new ApiUser(null, "Ronildo Junior", "Ronildo", "1234", new ArrayList<>()));
			apiUserService.saveUser(new ApiUser(null, "Michaela Langer", "Mika", "1234", new ArrayList<>()));
			apiUserService.saveUser(new ApiUser(null, "Ronaldo Braga", "Ronaldo", "1234", new ArrayList<>()));


			apiUserService.addRoleToUser("Ronildo", "USER");
			apiUserService.addRoleToUser("Mika", "MANAGER");
			apiUserService.addRoleToUser("Ronaldo", "ADMIN");
		};
	}
}
