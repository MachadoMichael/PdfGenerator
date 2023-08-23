package com.mcubed.pdfGenerator.entities;

public class Html {
    private final String full;

    public String getFull() {
        return full;
    }

    public Html(String body) {
        this.full = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\"></meta>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"></meta>\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    \n" +
                body +
                "    \n" +
                "</body>\n" +
                "</html>";
    }
}
