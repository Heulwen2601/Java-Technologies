package org.example.models;

import javax.persistence.*;
import lombok.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private int employee;

    @OneToMany(mappedBy = "manufacturer")
    private List<Phone> phones;

    public Manufacturer() {
        super();
    }
    public Manufacturer(String name, String location, int employee, List<Phone> phones) {
        this.name = name;
        this.location = location;
        this.employee = employee;
        this.phones = phones;
    }

}
