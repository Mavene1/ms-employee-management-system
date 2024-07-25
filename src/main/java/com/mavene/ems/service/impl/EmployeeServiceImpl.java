package com.mavene.ems.service.impl;

import com.mavene.ems.dto.EmployeeDto;
import com.mavene.ems.entity.Employee;
import com.mavene.ems.exception.ResourceNotFoundException;
import com.mavene.ems.mapper.EmployeeMapper;
import com.mavene.ems.repository.EmployeeRepository;
import com.mavene.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        // Save employee
        Employee employee = EmployeeMapper.toEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        // Return EmployeeDto
        return EmployeeMapper.toEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        // Get employee
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee not found with id: " + employeeId));

        // Return EmployeeDto
        return EmployeeMapper.toEmployeeDto(employee);
    }
}
