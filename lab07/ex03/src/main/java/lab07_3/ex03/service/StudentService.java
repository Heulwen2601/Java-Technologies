package lab07_3.ex03.service;
import lab07_3.ex03.model.Student;
public interface StudentService {
    public Iterable<Student> getStudents();
    public Student getStudent(int id);
    public void addStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(int id);
}
