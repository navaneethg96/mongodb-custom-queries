package com.example.mongodb.service;

import com.example.mongodb.model.Employee;
import com.example.mongodb.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.insert(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    public Map<String, Object> getAllEmployeeInPage(int pageNo, int pageSize, String sortBy) {
        Map<String, Object> response = new HashMap<>();
        Sort sort = Sort.by(sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Employee>  page= employeeRepository.findAll(pageable);
        response.put("Total Elements", page.getTotalElements());
        response.put("Data", page.getContent());
        response.put("Page Number", page.getNumber());      //Since page number convention starts with 0
        response.put("Per Page", page.getNumberOfElements());
        response.put("Total Pages", page.getTotalPages());
        return response;
    }
}
