package com.mcubed.pdfGenerator.services;
import com.lowagie.text.DocumentException;
import com.mcubed.pdfGenerator.entities.Html;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;

public class PdfService {

    private final byte[] file;

    public PdfService(String documentData) throws DocumentException {

        ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
        Html html = new Html(documentData);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html.getFull());
        renderer.layout();
        renderer.createPDF(pdfOutputStream);

        this.file = pdfOutputStream.toByteArray();
    }

    public byte[] getFile() {
        return file;
    }
}
