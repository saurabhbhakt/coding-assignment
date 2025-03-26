package com.rapid.csvupload.controller;


import com.rapid.csvupload.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final CSVService csvService;

    @Autowired
    public EmployeeController(CSVService csvService) {
        this.csvService = csvService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCSV(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please upload a CSV file!");
        }
        csvService.saveEmployeesFromCSV(file);
        return ResponseEntity.ok("CSV file uploaded and processed successfully!");
    }
}

