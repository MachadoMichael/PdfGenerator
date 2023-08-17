package com.mcubed.pdfGenerator.entities;
import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;

public class Pdf{

    private final byte[] file;

    public Pdf(String documentData) throws DocumentException {

        ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
        String html = "<!DOCTYPE html>\n" +
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
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(pdfOutputStream);

        this.file = pdfOutputStream.toByteArray();
    }

    public byte[] getFile() {
        return file;
    }
}
