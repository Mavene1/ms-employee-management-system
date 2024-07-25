package com.mavene.ems.controller;

import com.mavene.ems.dto.EmployeeDto;
import com.mavene.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ems")
@AllArgsConstructor
//@RequiredArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    //Build add Employee REST API
    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        System.out.println("Create and save employee.....");
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    //Build get employee by id REST API
    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        System.out.println("Get employee by Id.....");
        return ResponseEntity.ok(employeeDto);
    }

    //Build get all employees REST API
    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        System.out.println("Get all employees.....");
        return ResponseEntity.ok(employees);
    }

    //Build delete employee REST API
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        System.out.println("Delete employee.....");
        return ResponseEntity.ok("Employee deleted successfully!");
    }

    //Build update employee REST API
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDto updatedEmployee) {
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        System.out.println("Update employee.....");
        return ResponseEntity.ok(employeeDto);
    }
}
