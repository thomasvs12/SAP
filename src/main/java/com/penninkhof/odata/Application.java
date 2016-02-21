package com.penninkhof.odata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.penninkhof.odata.entities.Member;
import com.penninkhof.odata.repository.MemberRepository;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(final MemberRepository repository) {
		return (args) -> {
			// Add a couple of Members if the table is still empty
			if (repository.count() == 0) {
				repository.save(new Member("Jack", "Bauer"));
				repository.save(new Member("Chloe", "O'Brian"));
				repository.save(new Member("Kim", "Bauer"));
				repository.save(new Member("David", "Palmer"));
				repository.save(new Member("Michelle", "Dessler"));
			}
		};
	}

}