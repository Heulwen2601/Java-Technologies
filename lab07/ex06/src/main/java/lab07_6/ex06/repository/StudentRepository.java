package lab07_6.ex06.repository;

import lab07_6.ex06.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.age >= :age")
    List<Student> findByAge(int age);
    @Query("SELECT count(s) FROM Student s WHERE s.ielts = :ielts")
    int counting(double ielts);
    @Query("SELECT s FROM Student s WHERE s.name like %:name%")
    List<Student> findByName(String name);

}
