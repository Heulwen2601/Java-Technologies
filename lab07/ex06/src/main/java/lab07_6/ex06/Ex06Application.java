package lab07_6.ex06;

import lab07_6.ex06.model.Student;
import lab07_6.ex06.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Ex06Application implements CommandLineRunner {
	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(Ex06Application.class, args);
	}
	private void showStudents() {
		List<Student> students = (List<Student>) this.studentService.getStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}
	@Override
	public void run(String... args) throws Exception {
		List<Student> students = new ArrayList<>();

		students.add(new Student(1, "Trang", 20, "trang@gmail.com", 5.0));
		students.add(new Student(2, "Minh", 21, "minh@gmail.com", 7.0));
		students.add(new Student(3, "Hung", 22, "hung@gmail.com", 8.0));
		students.add(new Student(4, "Thao", 19, "thao@gmail.com", 6.0));
		students.add(new Student(5, "Lan", 23, "lan@gmail.com", 9.0));
		students.add(new Student(6, "Phuc", 20, "phuc@gmail.com", 6.0));
		students.add(new Student(7, "An", 22, "an@gmail.com", 7.0));
		students.add(new Student(8, "Ngoc", 21, "ngoc@gmail.com", 5.0));
		students.add(new Student(9, "Huy", 20, "huy@gmail.com", 8.0));
		students.add(new Student(10, "Vy", 19, "vy@gmail.com", 6.0));

		for (Student student : students) {
			this.studentService.addStudent(student);
		}

		showStudents();

		System.out.println("List of students:");
		List<Student> studentList = this.studentService.getStudentList();
		for (Student student : studentList) {
			System.out.println(student);
		}
	}
}
