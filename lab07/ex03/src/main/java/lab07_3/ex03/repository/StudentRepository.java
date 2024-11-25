package lab07_3.ex03.repository;

import lab07_3.ex03.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
