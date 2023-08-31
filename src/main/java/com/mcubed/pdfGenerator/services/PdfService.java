package com.mcubed.pdfGenerator.services;

import com.lowagie.text.DocumentException;
import com.mcubed.pdfGenerator.entities.Pdf;
import org.springframework.stereotype.Service;

@Service
public class PdfService {

    public byte[] generateFile(Pdf pdf) throws DocumentException {

        pdf.getRenderer().setDocumentFromString(pdf.getHtmlContent());
        pdf.getRenderer().layout();
        pdf.getRenderer().createPDF(pdf.getPdfOutputStream());
        return pdf.getPdfOutputStream().toByteArray();
    }

}
