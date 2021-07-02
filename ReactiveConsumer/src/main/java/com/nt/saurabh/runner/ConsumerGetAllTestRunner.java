package com.nt.saurabh.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.web.reactive.function.client.WebClient;

import com.nt.saurabh.model.Student;

import reactor.core.publisher.Flux;

public class ConsumerGetAllTestRunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		
		String url = "http://localhost:8087";

		
		WebClient client = WebClient.create(url);

		
		Flux<Student> flux = client
				.get()
				.uri("/student/all")
				.retrieve()
				.bodyToFlux(Student.class);


				flux.doOnNext(System.out::println).blockLast();
		
	}

}