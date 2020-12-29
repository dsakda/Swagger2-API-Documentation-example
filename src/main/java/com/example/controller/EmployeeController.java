package com.example.controller;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Api(tags = {"EmployeeController"})
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    @ApiOperation(value = "View a list of available employees", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @ApiOperation(value = "Get an employee by Id")
    @GetMapping("/{id}")
    public Employee getEmployeeById(
            @ApiParam(value = "Employee id from which employee object will retrieve", required = true)
            @PathVariable(value = "id") Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @ApiOperation(value = "Add an employee")
    @PostMapping("/create")
    public Employee createEmployee(
            @ApiParam(value = "Employee object store in database table", required = true)
            @Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @ApiOperation(value = "Update an employee")
    @PutMapping("/edit")
    public Employee editEmployee(
            @ApiParam(value = "Update employee object", required = true)
            @Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @ApiOperation(value = "Delete an employee")
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(
            @ApiParam(value = "Employee Id from which employee object will delete from database table", required = true)
            @PathVariable("id") Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
