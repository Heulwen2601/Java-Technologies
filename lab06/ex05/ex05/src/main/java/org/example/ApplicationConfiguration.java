package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {

    @Value("01")
    private String id;

    @Value("HongTraNgoGia")
    private String name;

    @Value("23")
    private String price;

    @Value("TraSua")
    private String description;

    @Bean
    @Scope("prototype")
    public Product product01() {
        Product product = new Product(Integer.valueOf(id), name, Double.valueOf(price), description);
        return product;
    }

    @Bean
    @Scope("prototype")
    public Product product02() {
        return new Product(product01());
    }

    @Bean
    @Scope("singleton")
    public Product product03() {
        Product product = new Product(03, "Katinat", 45, "Sweet");
        return product;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
    }
}
