package lab09_10.web.rfapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    private int id;
    private String name;
    private double price;
    private String brand;
    private String color;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;

    public Product(int i, String s, double v, String brandA, String red) {
        id = i;
        name = s;
        price = v;
        brand = brandA;
        color = red;
    }
}
