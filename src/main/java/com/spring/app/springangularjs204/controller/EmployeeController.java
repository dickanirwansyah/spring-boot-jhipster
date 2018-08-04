package com.spring.app.springangularjs204.controller;

import com.spring.app.springangularjs204.entity.Employee;
import com.spring.app.springangularjs204.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/employee")
@CrossOrigin(origins = {"*"})
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> list(){
        return employeeService.list();
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) throws URISyntaxException{
        try{
            Employee calbackJSON = employeeService.save(employee);
            return ResponseEntity.created(new URI("/api/employee/"+calbackJSON.getId())).body(calbackJSON);
        }catch (EntityExistsException ex){
            return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<Employee> update(@RequestBody Employee employee) throws  URISyntaxException{

        if (employee.getId() == 0){
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        try{
            Employee callbackJSON = employeeService.update(employee);
            return ResponseEntity.created(new URI("/api/employee"+callbackJSON.getId())).body(callbackJSON);
        }catch (EntityExistsException ex){
            return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
