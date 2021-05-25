package com.ani.security;

import com.ani.security.auth.AppUser;
import com.ani.security.auth.AppUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringBasicsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBasicsApplication.class, args);

		loadUsers(
				ctx.getBean(AppUserRepository.class),
				ctx.getBean(PasswordEncoder.class)
		);

	}

	private static void loadUsers(AppUserRepository repo, PasswordEncoder encoder) {

		repo.save(
				new AppUser(
						1L,
						"machine",
						encoder.encode("123"),
						"machine",
						true, true, true, true,
						"machine:start,machine:stop"
				)
		);

		repo.save(
				new AppUser(
						2L,
						"worker",
						encoder.encode("123"),
						"worker",
						true, true, true, true,
						"worker:login,machine:start"
				)
		);

	}

}
