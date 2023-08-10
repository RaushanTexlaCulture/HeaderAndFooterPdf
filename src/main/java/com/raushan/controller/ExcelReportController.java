package com.raushan.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raushan.services.EmployeeService;

@RestController
public class ExcelReportController {
	
	private EmployeeService employeeService;
	
	public ExcelReportController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/generate-excel-report")
    public ResponseEntity<byte[]> generateExcelReport() {
        Workbook workbook = employeeService.generateExcelReport();
        
        byte[] excelBytes;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            workbook.write(bos);
            excelBytes = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
            return ResponseEntity.status(HttpStatus.OK).build();
            
            
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "employee_report.xlsx");

        return ResponseEntity.ok().headers(headers).body(excelBytes);
        
    }

}
