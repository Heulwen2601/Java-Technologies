package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TextEditor {
    @Autowired
    @Qualifier("pdfTextWriter")
    private TextWriter writer;

    public void input(String text) {
        System.out.println(text);
    }
    public void save(String str) {
        writer.write("file", str);
    }

}
