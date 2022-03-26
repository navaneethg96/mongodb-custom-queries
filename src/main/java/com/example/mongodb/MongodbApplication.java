package com.example.mongodb;

import com.example.mongodb.model.Address;
import com.example.mongodb.model.Employee;
import com.example.mongodb.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//public class MongodbApplication implements CommandLineRunner {				// Uncomment this line while using command line error
public class MongodbApplication {

	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		List<Employee> employeeList = new ArrayList<>();
//
//		Employee e1 = new Employee("BAT", "MAN", new Address("Bat Cave", "Back Yard", "Gotham", "CA", 1234), 5000f);
//		Employee e2 = new Employee("SUPER", "MAN", new Address("Krypton Home", "Krypton City", "Krypton", "Space", 9999), 2000f);
//		Employee e3 = new Employee("Berry", "Allen", new Address("Police Station", "Star Lab", "Central City", "AAA", 3344), 6000f);
//
//		employeeList.add(e1);
//		employeeList.add(e2);
//		employeeList.add(e3);
//
//		employeeRepository.insert(employeeList);
//	}
}
