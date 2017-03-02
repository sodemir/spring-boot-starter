package com.example;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return evt ->
			Stream.of("sodemir,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong")
					.forEach(name -> userRepository.save(new User(name)));
	}

}