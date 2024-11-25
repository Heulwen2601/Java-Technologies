package org.example.models;


import javax.persistence.*;

@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private String color;

    @Column
    private String country;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "manufacturerID")
    private Manufacturer manufacturer;

    public Phone() {
        super();
    }
    public Phone(String name, int price, String color, String country, int quantity, Manufacturer manufacturer) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.country = country;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
    }
    public Phone(int id, String name, int price, String color, String country, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.country = country;
        this.quantity = quantity;
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
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    @Override
    public String toString() {
        return "Phone [id=" + id + ", name=" + name + ", price=" + price + ", color=" + color + ", country=" + country + ", quantity=" + quantity + "]";
    }
}
