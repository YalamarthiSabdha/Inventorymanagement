package com.inventory.controller;

import com.inventory.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/inventory/pdf")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<byte[]> generateInventoryReportPDF() {
        try {
            byte[] pdfBytes = reportService.generateInventoryReportPDF();
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "inventory-report.pdf");
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfBytes);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/inventory/csv")
    public ResponseEntity<String> generateInventoryReportCSV() {
        try {
            String csv = reportService.generateInventoryReportCSV();
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("text/csv"));
            headers.setContentDispositionFormData("attachment", "inventory-report.csv");
            
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(csv);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/transactions/pdf")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<byte[]> generateTransactionReportPDF(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        try {
            byte[] pdfBytes = reportService.generateTransactionReportPDF(startDate, endDate);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "transaction-report.pdf");
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfBytes);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/low-stock/csv")
    public ResponseEntity<String> generateLowStockReportCSV() {
        try {
            String csv = reportService.generateLowStockReportCSV();
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("text/csv"));
            headers.setContentDispositionFormData("attachment", "low-stock-report.csv");
            
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(csv);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
