package com.mavene.ems.service.impl;

import com.mavene.ems.dto.EmployeeDto;
import com.mavene.ems.entity.Employee;
import com.mavene.ems.exception.ResourceNotFoundException;
import com.mavene.ems.mapper.EmployeeMapper;
import com.mavene.ems.repository.EmployeeRepository;
import com.mavene.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    @Override
    public List<EmployeeDto> getAllEmployees() {

        // Get all employees
        List<Employee> employees = employeeRepository.findAll();

        // Return EmployeeDto
        return employees.stream().map((employee) ->
                EmployeeMapper.toEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        // Get employee
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee not found with id: " + employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee updatedEmployee1 = employeeRepository.save(employee);

        return EmployeeMapper.toEmployeeDto(updatedEmployee1);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        // Get employee
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee not found with id: " + employeeId));
        employeeRepository.deleteById(employeeId);
    }
}
