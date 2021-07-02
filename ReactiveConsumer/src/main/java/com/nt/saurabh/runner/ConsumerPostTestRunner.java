package com.nt.saurabh.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.web.reactive.function.client.WebClient;

import com.nt.saurabh.model.Student;

import reactor.core.publisher.Mono;


public class ConsumerPostTestRunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		
		String url = "http://localhost:8087";

		
		WebClient client = WebClient.create(url);

		
		Mono<Student> mono = client
				.post()
				.uri("/student/create")
				.body(Mono.just(new Student(1105, "RRR", 300.0)), Student.class)
				.retrieve()
				.bodyToMono(Student.class);


	
		mono.subscribe(System.out::println);
		System.out.println("OBJECT CREATED!!");
	}

}
