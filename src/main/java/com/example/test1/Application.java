package com.example.test1;

import com.example.test1.entity.Role;
import com.example.test1.entity.User;
import com.example.test1.repository.RoleRepository;
import com.example.test1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role role = new Role();
		role.setName("ADMIN");
		roleRepository.save(role);

		User user = new User((long)1, "Duong Nguyen", "t1@gmail.com", passwordEncoder.encode("123"), List.of(role));
		userRepository.save(user);
	}
}
