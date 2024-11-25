package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(TextConfig.class);
        TextEditor textEditor = (TextEditor) context.getBean("textEditor");
        textEditor.input("BMR");
        textEditor.save("!");
    }
}
