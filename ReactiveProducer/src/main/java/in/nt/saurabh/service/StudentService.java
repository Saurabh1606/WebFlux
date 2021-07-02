package in.nt.saurabh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.saurabh.model.Student;

import in.nt.saurabh.repo.StudentRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public Mono<Student> saveStudent(Student s)
	{
		return repo.save(s);
	}
	
	public Flux<Student> getAllStudents(){
		return repo.findAll().switchIfEmpty(Flux.empty());
		
	}
	
	public Mono<Student> getOneStudent(Integer id) {
		return repo.findById(id).switchIfEmpty(Mono.empty());
	}
	public Mono<Void> deleteOneStudent(Integer id) {
		return repo.deleteById(id);
	}
	

}
