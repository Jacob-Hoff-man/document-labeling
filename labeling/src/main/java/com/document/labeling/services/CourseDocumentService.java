package com.document.labeling.services;

import org.apache.pdfbox.pdmodel.PDDocument;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CourseDocumentService {
    public String parsePdfFile(final MultipartFile file) {
        String text;
        try {
            final PDDocument document = Loader.loadPDF(file.getBytes());
            final PDFTextStripper pdfStripper = new PDFTextStripper();
            text = pdfStripper.getText(document);
        } catch (final Exception ex) {
            text = "Error parsing PDF";
        }

        return text;
    }
}
