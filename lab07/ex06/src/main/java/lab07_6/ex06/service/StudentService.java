package lab07_6.ex06.service;

import lab07_6.ex06.model.Student;

import java.util.List;

public interface StudentService {
    public Iterable<Student> getStudents();
    public Student getStudent(int id);
    public void addStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(int id);
    public List<Student> findByAge(int age);
    public int countByIelts(double ielts);
    public List<Student> findByName(String name);
    public Iterable<Student> getAllStudentsSort();
    public List<Student> getStudentList();
}
