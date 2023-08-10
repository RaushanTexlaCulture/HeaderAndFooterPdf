package com.raushan.services;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.raushan.data.model.EmployeeDeatils;
import com.raushan.repositories.EmployeeDetailsEntityRepository;

@Service
public class EmployeeService {
	
	private EmployeeDetailsEntityRepository employeeDetailsEntityRepository;
	
	public EmployeeService (EmployeeDetailsEntityRepository employeeDetailsEntityRepository) {
		this.employeeDetailsEntityRepository = employeeDetailsEntityRepository;
	}
		
		public Workbook generateExcelReport() {
	        List<EmployeeDeatils> employeesDeatils = employeeDetailsEntityRepository.findAll();
	        
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("Employee Report3");
	        
	        int rowNum = 0;
	        for (EmployeeDeatils employee : employeesDeatils) {
	            Row row = sheet.createRow(rowNum++);
	            row.createCell(0).setCellValue(employee.getId());
	            row.createCell(1).setCellValue(employee.getName());
	            row.createCell(2).setCellValue(employee.getAge());
	            // Add more cells for other data fields if needed
	        }

	        return workbook;
	        
	        
	}

}
