package com.nt.saurabh.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.web.reactive.function.client.WebClient;

import com.nt.saurabh.model.Student;

import reactor.core.publisher.Mono;

//@Component
public class ConsumerGetOneTestRunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		
		String url = "http://localhost:8087";

		
		WebClient client = WebClient.create(url);

		Mono<Student> mono = client
				.get()
				.uri("/student/one/{id}",1102)
				.retrieve()
				.bodyToMono(Student.class);


		//5. print result
		mono.subscribe(System.out::println);

	}

}
