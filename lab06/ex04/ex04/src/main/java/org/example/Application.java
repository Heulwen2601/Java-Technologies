package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class Application {
    private static ApplicationContext context;
    public static void main( String[] args )
    {
        context = new AnnotationConfigApplicationContext(Application.class);
        TextEditor textEditor = (TextEditor) context.getBean("textEditor");
        textEditor.input("BMR");
        textEditor.save("!");
    }
}
