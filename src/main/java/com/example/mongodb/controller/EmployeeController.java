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
            @RequestParam(name = "page_no", defaultValue = "0") int pageNo,      //Since page number convention starts with 0
            @RequestParam(name = "page_size", defaultValue = "2") int pageSize,
            @RequestParam(name = "sort_by", defaultValue = "id") String sortBy
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

    /**
     *
     * @param firstName
     * @return employee list based on firstName
     */
    @GetMapping("/firstname")
    public List<Employee> getAllByFirstName(@RequestParam(name = "first_name") String firstName) {
        return employeeService.getAllByFirstName(firstName);
    }

    /**
     *
     * @param firstName
     * @return employee list based on firstName starting with the input parameter
     */
    @GetMapping("/start")
    public List<Employee> getAllNamesStartWith(@RequestParam(name = "start_with") String firstName) {
        return employeeService.getAllNamesStartWith(firstName);
    }

    /**
     *
     * @param zipCode
     * @return list of employees based on zipcode present in a different Entity class
     */
    @GetMapping("/zipcode")
    public List<Employee> getByZipCode(@RequestParam(name = "zipcode") int zipCode) {
        return employeeService.getByZipCode(zipCode);
    }

    /**
     *
     * @param salary
     * @return list of specific employee fields based on salary filter(GT,GTE,LT,LTE,etc...) using @Query() annotation
     */
    @GetMapping("/salary")
    public List<Employee> getAllBySalary(@RequestParam(name = "salary") float salary) {
        return employeeService.getAllBySalary(salary);
    }
}
