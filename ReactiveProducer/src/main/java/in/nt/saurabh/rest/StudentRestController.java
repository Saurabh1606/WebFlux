package in.nt.saurabh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.saurabh.model.Student;

import in.nt.saurabh.service.StudentService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Student")
public class StudentRestController {
	
	@Autowired
	private StudentService service;
	
	
	@PostMapping("/create")
	public Mono<Student> saveStudent(
			@RequestBody Student student
			) 
	{
		return service.saveStudent(student);
	}
	
	@GetMapping("/all")
	public Flux<Student> getAllStudents() {
		return service.getAllStudents();
	}
	
	@GetMapping("/one/{id}")
	public Mono<Student> getOneStudents(
			@PathVariable Integer id) 
	{
		return service.getOneStudent(id);
	}
	
	@DeleteMapping("/remove/{id}")
	public Mono<Void> deleteStudent(
			@PathVariable Integer id
			) 
	{
		return service.deleteOneStudent(id);
	}
}
