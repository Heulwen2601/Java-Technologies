package lab07_3.ex03.model;

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
    private double ielts_score;
    public Student(int id, String name, int age, String email, double ielts_score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.ielts_score = ielts_score;
    }
    public Student(){}

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", ielts_score=" + ielts_score + "]";
    }
}
