package com.mcubed.pdfGenerator.dto;

import java.util.List;

public record PdfRequest(List<String> recipientsEmail, String documentData) {
}
