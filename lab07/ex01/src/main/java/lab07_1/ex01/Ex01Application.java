package lab07_1.ex01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex01Application implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World");
	}

	public static void main(String[] args) {
		SpringApplication.run(Ex01Application.class, args);
	}

}
