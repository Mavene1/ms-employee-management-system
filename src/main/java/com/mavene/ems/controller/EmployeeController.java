package com.mavene.ems.controller;

import com.mavene.ems.dto.EmployeeDto;
import com.mavene.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    //Build add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
//        return ResponseEntity.ok(savedEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build get all employees REST API
//    @RequestMapping
//    public Iterable<EmployeeDto> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }

}
