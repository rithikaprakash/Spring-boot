package com.company.employee.controller;

import com.company.employee.Service.EmployeeService;
import com.company.employee.model.EmployeeEntity;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> list=service.getAllEmployees();
        return  new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/{id")
    public ResponseEntity<EmployeeEntity> getEmployeeWithId(@PathVariable("id") Long id) throws NotFoundException {
        EmployeeEntity entity=service.getEmployeeWithId(id);
        return new ResponseEntity<EmployeeEntity>(entity,new HttpHeaders(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(EmployeeEntity employee) throws NotFoundException{
        EmployeeEntity updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(updated,new HttpHeaders(),HttpStatus.OK);
    }
    @DeleteMapping("{/id}")
    public HttpStatus deleteEmployeeWithId(@PathVariable("id") Long id) throws NotFoundException{
        service.deleteEmployeeWithId(id);
        return HttpStatus.FORBIDDEN;
    }

}
