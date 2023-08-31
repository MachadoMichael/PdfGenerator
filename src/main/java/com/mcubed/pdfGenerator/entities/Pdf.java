package com.mcubed.pdfGenerator.entities;

import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;


public class Pdf {

    private ByteArrayOutputStream pdfOutputStream;
    private ITextRenderer renderer;
    private String htmlContent;

    public Pdf(String bodyHtml) {
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
                bodyHtml +
                "    \n" +
                "</body>\n" +
                "</html>";
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public ByteArrayOutputStream getPdfOutputStream() {
        return pdfOutputStream;
    }

    public void setPdfOutputStream(ByteArrayOutputStream pdfOutputStream) {
        this.pdfOutputStream = pdfOutputStream;
    }

    public ITextRenderer getRenderer() {
        return renderer;
    }

    public void setRenderer(ITextRenderer renderer) {
        this.renderer = renderer;
    }
}
