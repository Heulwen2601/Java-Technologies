package org.example;

import org.springframework.stereotype.Component;

@Component
public class PlainTextWriter implements TextWriter{
    @Override
    public void write(String str1, String str2) {
        System.out.println("Plain text " + str1 + " to " + str2);
    }
}
