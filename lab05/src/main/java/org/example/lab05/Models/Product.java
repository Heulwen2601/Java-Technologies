package org.example.lab05.Models;


import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
        super();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}