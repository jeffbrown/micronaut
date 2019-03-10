package com.milamed.controller;

import com.milamed.dao.EmployeeRepository;
import com.milamed.dao.EmployeeRepositoryImpl;
import com.milamed.entity.Employee;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;

import java.util.List;

@Validated
@Controller("/employee")
public class EmployeeController {


    private EmployeeRepositoryImpl employeeRepository;

    public EmployeeController(EmployeeRepositoryImpl employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Get("/")
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @Post("/")
    public Employee create(@Body Employee employee) {
        return employeeRepository.save(employee);
    }
}
