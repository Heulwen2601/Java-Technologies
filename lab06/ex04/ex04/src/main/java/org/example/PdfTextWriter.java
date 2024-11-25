package org.example;

import org.springframework.stereotype.Component;

@Component
public class PdfTextWriter implements TextWriter {
    @Override
    public void write(String fileName, String text) {
        System.out.println("PdfText: Writing text to " + fileName);
    }
}
