package com.example.mongodb.controller;

import com.example.mongodb.model.Employee;
import com.example.mongodb.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     *
     * @return all the employees from mongodb
     */
    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    /**
     *
     * @param employee
     * @return the new employee object added
     */
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    /**
     *
     * @param employee
     * @return the updated employee object
     */
    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    /**
     *
     * @param id
     * @return a string that the requested id has been deleted
     */
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        String message = "Employee with id %s deleted successfully";
        return String.format(message, id);
    }

    /**
     *
     * @param pageNo
     * @param pageSize
     * @param sortBy
     * @return list of employees with the pagination and sorting filters
     */
    @GetMapping("/page")
    public Map<String, Object> getAllEmployeeInPage(
            @RequestParam(value = "page_no", defaultValue = "0") int pageNo,      //Since page number convention starts with 0
            @RequestParam(value = "page_size", defaultValue = "2") int pageSize,
            @RequestParam(value = "sort_by", defaultValue = "id") String sortBy
    ) {
        return employeeService.getAllEmployeeInPage(pageNo, pageSize, sortBy);
    }

    /**
     *
     * @param employee
     * @return employee list matching with the ExampleMatcher
     */
    @GetMapping("/example")
    public List<Employee> getAllEmployeeByExample(@RequestBody Employee employee) {
        return employeeService.getAllEmployeeByExample(employee);
    }
}
