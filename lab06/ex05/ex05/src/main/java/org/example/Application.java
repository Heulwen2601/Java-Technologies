package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class Application {
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Product product01 = (Product) context.getBean("product01");
        Product product02 = (Product) context.getBean("product02");
        Product product03 = (Product) context.getBean("product03");

        System.out.println(product01);
        System.out.println(product02);
        System.out.println(product03);
    }
}
