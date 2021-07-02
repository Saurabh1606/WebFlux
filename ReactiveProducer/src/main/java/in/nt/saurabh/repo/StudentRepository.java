package in.nt.saurabh.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nt.saurabh.model.Student;

public interface StudentRepository extends ReactiveMongoRepository<Student, Integer> {

}
