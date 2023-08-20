package com.mcubed.pdfGenerator.controllers;

import com.lowagie.text.DocumentException;
import com.mcubed.pdfGenerator.services.PdfService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pdf")
public class PdfController {

    @PostMapping("/generate")
    public byte[] generate(@RequestBody String documentData) throws DocumentException {
        PdfService pdf = new PdfService(documentData);
        return pdf.getFile();
    }
}
