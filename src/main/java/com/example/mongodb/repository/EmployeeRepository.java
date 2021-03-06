package com.example.mongodb.repository;

import com.example.mongodb.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByFirstNameStartingWith(String firstName);

    List<Employee> findByAddressZipCode(int zipCode);

    @Query(value = "{'salary' : {$gte : ?0}}", fields = "{'firstName' : 1, 'salary' : 1, 'id' : 0}")
    List<Employee> findBySalary(float salary);
}
