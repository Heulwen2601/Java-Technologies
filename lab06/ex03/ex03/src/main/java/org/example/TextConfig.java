package org.example;
import org.springframework.context.annotation.*;

@Configuration
public class TextConfig {
    @Bean
    public TextWriter plainTextWriter() {
        return new PlainTextWriter();
    }

    @Bean
    public TextWriter pdfTextWriter() {
        return new PdfTextWriter();
    }

    @Bean
    public TextEditor textEditor() {
        return new TextEditor();
    }

}
