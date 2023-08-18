package com.mcubed.pdfGenerator.controllers;

import com.lowagie.text.DocumentException;
import com.mcubed.pdfGenerator.dto.PdfRequest;
import com.mcubed.pdfGenerator.services.EmailService;
import com.mcubed.pdfGenerator.services.PdfService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pdf")
public class PdfResource {

    @PostMapping("/generate")
    public byte[] generate(@RequestBody String documentData) throws DocumentException {
        PdfService pdf = new PdfService(documentData);
        return pdf.getFile();
    }

    @PostMapping("/generateAndSend")
    public String generateAndSend(@RequestBody PdfRequest pdfRequest) throws DocumentException {
        PdfService pdf = new PdfService(pdfRequest.documentData());
        EmailService email = new EmailService();
        email.send(pdf.getFile(), pdfRequest.recipientsEmail());
        return null;
    }
}
