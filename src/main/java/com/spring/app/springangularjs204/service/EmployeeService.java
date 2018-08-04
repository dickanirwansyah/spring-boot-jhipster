package com.spring.app.springangularjs204.service;

import com.spring.app.springangularjs204.entity.Employee;
import com.spring.app.springangularjs204.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee){
        if (employee.getId() != 0 && employeeRepository.existsById(employee.getId())){
            throw new EntityExistsException("sorry id employee is exists");
        }
        return employeeRepository.save(employee);
    }

    public Employee update(Employee employee){
        if (employee.getId() != 0 && !employeeRepository.existsById(employee.getId())){
            throw new EntityNotFoundException("sorry id employee not exists");
        }
        return employeeRepository.save(employee);
    }

    public List<Employee> list(){
        List<Employee> employees = new ArrayList<>();
        for (Employee employee: employeeRepository.findAll()){
            employees.add(employee);
        }
        return employees;
    }

    public Optional<Employee> getId(Integer id){
        return employeeRepository.findById(id);
    }

    public void delete(Integer id){
        employeeRepository.deleteById(id);
    }
}
