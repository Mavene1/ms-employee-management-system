package com.mavene.ems.service;

import com.mavene.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    //Build add Employee REST API
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    //Build get employee by id REST API
    EmployeeDto getEmployeeById(Long employeeId);


    //Build get all employees REST API
    List<EmployeeDto> getAllEmployees();

    //Build update employee REST API
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    //Build delete employee REST API
    void deleteEmployee(Long employeeId);
}
