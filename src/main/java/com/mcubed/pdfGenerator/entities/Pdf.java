package com.mcubed.pdfGenerator.entities;

import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;


public class Pdf {

    private final ByteArrayOutputStream pdfOutputStream;
    private final ITextRenderer renderer;
    private final String htmlContent;

    public Pdf(String documentData) {
        pdfOutputStream = new ByteArrayOutputStream();
        renderer = new ITextRenderer();

        htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\"></meta>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"></meta>\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    \n" +
                documentData +
                "    \n" +
                "</body>\n" +
                "</html>";
    }

    public String getHtmlContent() {
        return htmlContent;
    }
    public ByteArrayOutputStream getPdfOutputStream() {
        return pdfOutputStream;
    }
    public ITextRenderer getRenderer() {
        return renderer;
    }
}
