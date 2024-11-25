package lab07_6.ex06.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private int age;
    private String email;
    private Double ielts;

    public Student(int id, String name, int age, String email, double ielts) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.ielts = ielts;
    }
    public Student(){}

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", ielts=" + ielts + "]";
    }
}
