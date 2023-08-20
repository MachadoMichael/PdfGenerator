package com.mcubed.pdfGenerator.controllers;

import com.mcubed.pdfGenerator.services.PdfService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pdf")
public class PdfController {

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generate(@RequestBody String documentData) {
        try {
            PdfService pdf = new PdfService(documentData);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "file.pdf");

            return new ResponseEntity<>(pdf.getFile(), headers, HttpStatus.OK);
        } catch (RuntimeException e) {

            String messageToUser = e.getCause().getMessage().split(";")[3];
            return ResponseEntity.badRequest().body(messageToUser.getBytes());
        }
    }
}
