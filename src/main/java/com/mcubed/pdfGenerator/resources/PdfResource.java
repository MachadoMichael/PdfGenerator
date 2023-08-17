package com.mcubed.pdfGenerator.resources;

import com.lowagie.text.DocumentException;
import com.mcubed.pdfGenerator.dto.PdfRequestDTO;
import com.mcubed.pdfGenerator.entities.Email;
import com.mcubed.pdfGenerator.entities.Pdf;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pdf")
public class PdfResource {
    @PostMapping("/generate")
    public byte[] generate(@RequestBody String documentData) throws DocumentException {
        Pdf pdf = new Pdf(documentData);
        return pdf.getFile();
    }

    @PostMapping("/generateAndSend")
    public String generateAndSend(@RequestBody PdfRequestDTO pdfRequest) throws DocumentException {
        Pdf pdf = new Pdf(pdfRequest.documentData());
        Email.send(pdf.getFile(), pdfRequest.recipientsEmail());
        return null;
    }
}
