package com.inventory.service;

import com.inventory.entity.Product;
import com.inventory.entity.Transaction;
import com.inventory.repository.ProductRepository;
import com.inventory.repository.TransactionRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public byte[] generateInventoryReportPDF() throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, out);
        document.open();

        // Title
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Paragraph title = new Paragraph("Inventory Summary Report", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(20);
        document.add(title);

        // Date
        Font dateFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.GRAY);
        Paragraph date = new Paragraph("Generated: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), dateFont);
        date.setAlignment(Element.ALIGN_CENTER);
        date.setSpacingAfter(20);
        document.add(date);

        // Product Table
        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        // Headers
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.WHITE);
        String[] headers = {"SKU", "Name", "Category", "Quantity", "Unit", "Price", "Supplier"};
        
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
            cell.setBackgroundColor(BaseColor.DARK_GRAY);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(5);
            table.addCell(cell);
        }

        // Data
        Font cellFont = FontFactory.getFont(FontFactory.HELVETICA, 9);
        List<Product> products = productRepository.findAll();
        
        for (Product product : products) {
            table.addCell(new Phrase(product.getSku(), cellFont));
            table.addCell(new Phrase(product.getName(), cellFont));
            table.addCell(new Phrase(product.getCategory() != null ? product.getCategory() : "N/A", cellFont));
            table.addCell(new Phrase(String.valueOf(product.getQuantity()), cellFont));
            table.addCell(new Phrase(product.getUnit(), cellFont));
            table.addCell(new Phrase("$" + product.getPrice().toString(), cellFont));
            table.addCell(new Phrase(product.getSupplier() != null ? product.getSupplier() : "N/A", cellFont));
        }

        document.add(table);

        // Summary
        Paragraph summary = new Paragraph("\nTotal Products: " + products.size(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
        document.add(summary);

        document.close();
        return out.toByteArray();
    }

    public String generateInventoryReportCSV() {
        StringWriter writer = new StringWriter();
        CSVWriter csvWriter = new CSVWriter(writer);

        // Headers
        String[] headers = {"SKU", "Name", "Category", "Quantity", "Unit", "Price", "Min Threshold", "Supplier"};
        csvWriter.writeNext(headers);

        // Data
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            String[] data = {
                product.getSku(),
                product.getName(),
                product.getCategory() != null ? product.getCategory() : "N/A",
                String.valueOf(product.getQuantity()),
                product.getUnit(),
                product.getPrice().toString(),
                String.valueOf(product.getMinThreshold()),
                product.getSupplier() != null ? product.getSupplier() : "N/A"
            };
            csvWriter.writeNext(data);
        }

        try {
            csvWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return writer.toString();
    }

    public byte[] generateTransactionReportPDF(LocalDateTime startDate, LocalDateTime endDate) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, out);
        document.open();

        // Title
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Paragraph title = new Paragraph("Transaction History Report", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(20);
        document.add(title);

        // Date Range
        Font dateFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.GRAY);
        String dateRange = "Period: " + startDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + 
                          " to " + endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Paragraph datePara = new Paragraph(dateRange, dateFont);
        datePara.setAlignment(Element.ALIGN_CENTER);
        datePara.setSpacingAfter(20);
        document.add(datePara);

        // Transaction Table
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);

        // Headers
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.WHITE);
        String[] headers = {"Date", "Product", "Type", "Quantity", "Price", "User"};
        
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
            cell.setBackgroundColor(BaseColor.DARK_GRAY);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(5);
            table.addCell(cell);
        }

        // Data
        Font cellFont = FontFactory.getFont(FontFactory.HELVETICA, 9);
        List<Transaction> transactions = transactionRepository.findByTimestampBetween(startDate, endDate);
        
        for (Transaction transaction : transactions) {
            table.addCell(new Phrase(transaction.getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), cellFont));
            table.addCell(new Phrase(transaction.getProduct().getName(), cellFont));
            table.addCell(new Phrase(transaction.getType().name(), cellFont));
            table.addCell(new Phrase(String.valueOf(transaction.getQuantity()), cellFont));
            table.addCell(new Phrase("$" + transaction.getPrice().toString(), cellFont));
            table.addCell(new Phrase(transaction.getUser().getUsername(), cellFont));
        }

        document.add(table);

        // Summary
        Paragraph summary = new Paragraph("\nTotal Transactions: " + transactions.size(), 
                                         FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
        document.add(summary);

        document.close();
        return out.toByteArray();
    }

    public String generateLowStockReportCSV() {
        StringWriter writer = new StringWriter();
        CSVWriter csvWriter = new CSVWriter(writer);

        // Headers
        String[] headers = {"SKU", "Name", "Current Stock", "Min Threshold", "Shortage", "Supplier"};
        csvWriter.writeNext(headers);

        // Data
        List<Product> products = productRepository.findLowStockProducts();
        for (Product product : products) {
            String[] data = {
                product.getSku(),
                product.getName(),
                String.valueOf(product.getQuantity()),
                String.valueOf(product.getMinThreshold()),
                String.valueOf(product.getMinThreshold() - product.getQuantity()),
                product.getSupplier() != null ? product.getSupplier() : "N/A"
            };
            csvWriter.writeNext(data);
        }

        try {
            csvWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return writer.toString();
    }
}
