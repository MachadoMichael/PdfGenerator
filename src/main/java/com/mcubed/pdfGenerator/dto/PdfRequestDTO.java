package com.mcubed.pdfGenerator.dto;

import java.util.List;

public record PdfRequestDTO(List<String> recipientsEmail, String documentData) {
}
