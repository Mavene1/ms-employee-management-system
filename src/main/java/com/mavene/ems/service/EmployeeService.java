package com.mavene.ems.service;

import com.mavene.ems.dto.EmployeeDto;

public interface EmployeeService {

    //Build add Employee REST API
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    //Build get employee by id REST API
    EmployeeDto getEmployeeById(Long employeeId);


    //Build get all employees REST API
//    Iterable<EmployeeDto> getAllEmployees();
}
