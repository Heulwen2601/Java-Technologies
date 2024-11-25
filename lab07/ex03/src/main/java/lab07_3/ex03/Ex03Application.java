package lab07_3.ex03;

import lab07_3.ex03.model.Student;
import lab07_3.ex03.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Ex03Application implements CommandLineRunner {
	@Autowired
	private StudentService studentService;
	public static void main(String[] args) {
		SpringApplication.run(Ex03Application.class, args);
	}
	private void showStudents() {
		List<Student> students = (List<Student>) this.studentService.getStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}
	@Override
	public void run(String... args) {
		Student student01 = new Student(01, "Trang", 20, "traang180204@gmail.com", 9.0);
		Student student02 = new Student(02, "Thanh", 21, "thanhhard@gmail.com", 7.0);
		Student student03 = new Student(03, "Pino", 20, "pino@gmail.com", 8.0);
		this.studentService.addStudent(student01);
		this.studentService.addStudent(student02);
		this.studentService.addStudent(student03);
		showStudents();

		System.out.println("Old name of student 01: " + student01.getName());
		student01.setName("Ruoc");
		this.studentService.updateStudent(student01);
		showStudents();

		System.out.println("Id of student will delete: " + student01.getId());
		this.studentService.deleteStudent(student01.getId());
		showStudents();

	}
}
