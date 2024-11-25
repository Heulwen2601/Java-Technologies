package org.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext applicationContext =
                     new ClassPathXmlApplicationContext("appConfig.xml")) {

            Product product01 = applicationContext.getBean("product01", Product.class);
            Product product02 = applicationContext.getBean("product02", Product.class);
            Product product03 = applicationContext.getBean("product03", Product.class);

            System.out.println(product01);
            System.out.println(product02);
            System.out.println(product03);

            System.out.println(product01 == applicationContext.getBean("product01", Product.class));
            System.out.println(product02 == applicationContext.getBean("product02", Product.class));
            System.out.println(product03 == applicationContext.getBean("product03", Product.class));
        }
    }
}
