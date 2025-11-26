package com.javaimplant.java17.features;

public class LongTextMain {
    static void main() {
        String text = """
                In computer programming, a multi-line string, also known as a here document or heredoc, is a string literal that preserves the formatting of the text within it, including line breaks and indentation. Multi-line strings are useful for representing large blocks of text, such as HTML, XML, JSON, or SQL queries, without the need for concatenation or escape characters.
                Different programming languages have different syntax for defining multi-line strings. For example:
                - In Python, multi-line strings can be created using triple quotes (''' or \""").
                - In JavaScript, template literals (enclosed by backticks ``) allow for multi-line strings.
                - In Java (from version 13 onwards), text blocks (enclosed by triple double quotes \""") provide a way to define multi-line strings.

                Multi-line strings enhance code readability and maintainability by allowing developers to include large text blocks directly in their code without complex formatting.
                """;
        System.out.println(text);
    }
}
