package com.mavene.ems.repository;

import com.mavene.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    Optional<Employee> findByEmail(String email); // <2>
}
