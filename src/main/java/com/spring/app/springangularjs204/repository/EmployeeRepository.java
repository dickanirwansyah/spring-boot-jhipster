package com.spring.app.springangularjs204.repository;

import com.spring.app.springangularjs204.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByName(String name);
}
