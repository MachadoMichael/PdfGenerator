package com.mcubed.pdfGenerator.controllers;

import com.lowagie.text.DocumentException;
import com.mcubed.pdfGenerator.entities.Pdf;
import com.mcubed.pdfGenerator.services.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pdf")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generate(@RequestBody String documentData) {
        try {
            Pdf pdf = new Pdf(documentData);
            byte[] pdfFile = pdfService.generateFile(pdf);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "file.pdf");

            return new ResponseEntity<>(pdfFile, headers, HttpStatus.OK);
        } catch (RuntimeException e) {

            String messageToUser = e.getCause().getMessage().split(";")[3];
            return ResponseEntity.badRequest().body(messageToUser.getBytes());
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}
